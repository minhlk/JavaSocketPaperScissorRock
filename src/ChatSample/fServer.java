package ChatSample;

import DAO.UserDAO;
import Model.User;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MinhLK
 */
public class fServer extends javax.swing.JFrame {

    Server server;
    public fServer() {
        initComponents();
        server = new Server(9999);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tServer = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Server_Start(evt);
            }
        });

        jButton2.setText("End");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Server_End(evt);
            }
        });

        tServer.setColumns(20);
        tServer.setRows(5);
        jScrollPane1.setViewportView(tServer);
        tServer.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Server_Start(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Server_Start
      Thread thread = new Thread(server);
      thread.start(); 
    }//GEN-LAST:event_Server_Start

    private void Server_End(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Server_End
        
        server.EndServer();
    }//GEN-LAST:event_Server_End

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fServer().setVisible(true);
            }
        });
    }

    
    
    
    public class ClientHandler implements Runnable{
    ObjectInputStream reader; 
    ObjectOutputStream writer;
    public boolean isActive = true;
    public long id = 0;
    

    public ClientHandler(Socket socket,ObjectOutputStream out,ObjectInputStream in){
      this.writer = out;
      this.reader = in;
    }
   
    @Override
    public void run() {
           
        try {
                while( true){

                    System.out.println("server is watting");
                    ClientObject client =(ClientObject)reader.readObject();
                    
                       
                    if(!ServerHandler.Contain(client)){
                        id = client.id;
                        ServerHandler.users.add(client);
                    }
                    if(client.message.isEmpty() ){
                        if(client.choose != -1){
                            if(ServerHandler.isAllReady() && !ServerHandler.isMessAllSet())
                                continue;
                            else
                                ServerHandler.checkWin();
                            
                        }
                            //update new users
                             for(ObjectOutputStream write : ServerHandler.GetOOS()){
                                write.writeObject(ServerHandler.users.toArray(new ClientObject[4]));
                                write.reset();
                             }
                            continue;
                        }
                      
                    
                    for(ObjectOutputStream write : ServerHandler.GetOOS()){
                        write.writeObject(client);
                        write.reset();
                    }

                    tServer.append(client.message + "\n");

                }
        } catch (IOException ex) {
             System.out.println("Can't create thread for client " + ex.getMessage());
             ServerHandler.RemoveUser(id);
             for(ObjectOutputStream write : ServerHandler.GetOOS()){
                 try {
                     write.writeObject(ServerHandler.users.toArray(new ClientObject[4]));
                     write.reset();
                 } catch (IOException ex1) {
                     System.out.println("client disconnected " + ex.getMessage());
                 }
             }
              ServerHandler.Remove(writer);
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fServer.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
}
    
    public class Server implements Runnable{
    private int port;
    private boolean isRunning = false;
    private ServerSocket server;
    private ThreadPoolExecutor execute;       
    public Server(int port){
        this.port = port;
    }
    private void StartServer(){
        try {
            isRunning = true;
            server = new ServerSocket(port);
            execute = new ThreadPoolExecutor(4,4,0L,
                    TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>());       
            while(true){
                System.out.println("Server's starting");
                // create thread for handle new client connect to server
                Socket sock = server.accept();
                if(CountActive() > 3 ){
                    System.out.println("phong da day");
                    sock.getOutputStream().write(1);
                }
                else{
                    sock.getOutputStream().write(0);
                    ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());
                    ObjectInputStream in = new ObjectInputStream(sock.getInputStream());
                    User user ;
                    if((user = (User)in.readObject()) instanceof User){
                        UserDAO dao = new UserDAO();
                        User rs = dao.Login(user);
                        out.writeObject(rs);
                        if(rs == null)
                            continue;
                    }
                    ServerHandler.Add(out);
                    ClientHandler handler = new ClientHandler(sock,out,in);
                    execute.execute(handler);
                    
                }
                
            }
            
        } catch (IOException ex) {
            System.out.println("Server can't start " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void EndServer(){
        if(isRunning)
        try {
            server.close();
            execute.shutdown();
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("Server can't stop " + ex.getMessage());
        }
    }
 
     public int CountActive(){
        return execute.getActiveCount();
    }
    
    @Override
    public void run() {
       StartServer();
    }
}
    public static class ServerHandler{
     private static ArrayList<ObjectOutputStream> oos = new ArrayList<>();
     public  static ArrayList<ClientObject> users = new ArrayList<>();
    private static UserDAO userDao = new UserDAO();
     public static ArrayList<ObjectOutputStream> GetOOS(){
         return oos;
         
     }
     public synchronized static void Remove(ObjectOutputStream os){
         oos.remove(os);
     }
      public synchronized static void Add(ObjectOutputStream os){
         oos.add(os);
     }
      public synchronized static boolean Contain(ClientObject client){
            for(int i = 0 ; i < users.size() ; i++){
            if(users.get(i).id == client.id){
               ClientObject user = client;
               users.set(i, user);
               return true;
           }
        }
           return false;
      }
       public  synchronized static void RemoveUser(long id){
         
                for(int i = 0 ; i < users.size() ; i++){
                    if(users.get(i).id == id){
                       users.remove(i);
                    }
                }
           
      }  
       public synchronized static boolean isAllReady(){
           for(ClientObject user : users){
               if(!user.isReady ) return false;
           }
           return true;
       }
      public synchronized static boolean isMessAllSet(){
          
       
               for(int i = 0 ; i < users.size() ; i++){
                   if(users.get(i).choose == -1)
                       return false;
               }
           return true;
          
         
      }

        private static void setDefaultAll() {
          
               for(int i = 0 ; i < users.size() ; i++){
                   ClientObject user = users.get(i);
                   user.choose = -1;
                    user.isReady = false;
                       users.set(i, user);
               }
        }
        private static void checkWin(){
            //edit calculate winner algorithm again @@
            boolean[] rs = new boolean[users.size()];
                  for(int i = 0 ; i < users.size() - 1;i++){
                      for(int j = i+ 1; j < users.size();j++){
                        ClientObject user1 = users.get(i);
                        ClientObject user2 = users.get(j);
                        byte one = user1.choose;
                        byte two = user2.choose;
                        if(one  -  two == 1 || two - one == 2 ){
                                rs[i] = true;
                                rs[j] = false;
                        }
                        else if(one  -  two == -1 || two - one == -2 ){
                                rs[i] = false;
                                rs[j] = true;
                        }
                      }
                  }
                  setDefaultAll();
                  int numOfWin = 0;
                   for(int i = 0 ; i < rs.length; i++)
                       if(rs[i])
                           numOfWin++;
                  
                  for(int i = 0 ; i < rs.length; i++){
                      ClientObject temp = users.get(i);
                      //win
                      if(rs[i])
                          temp.amount += 10 / numOfWin;
                      else
                          temp.amount -= 10;
                      userDao.EditAmount(temp.amount, temp.id);
                      users.set(i, temp);
                  }
                  
                  
                  
                  
                  
        }
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea tServer;
    // End of variables declaration//GEN-END:variables
}
