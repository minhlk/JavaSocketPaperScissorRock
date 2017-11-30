package Model;
// Generated Nov 30, 2017 6:43:39 PM by Hibernate Tools 4.3.1


//import java.io.String;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */

@Entity
@Table(name="\"User\""
    ,schema="dbo"
    ,catalog="scissorrockpaper"
)
public class User  implements java.io.Serializable {
    
     private long id;
     private String userName;
     private String password;
     private String email;
     private long amount;
     private Set<Deposit> deposits = new HashSet<Deposit>(0);

    public User() {
    }

    public User(String userName, String password, String email, long amount) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.amount = amount;
    }
    public User(long id, String userName, String password, String email, long amount) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.amount = amount;
    }
    public User(long id, String userName, String password, String email, long amount, Set<Deposit> deposits) {
       this.id = id;
       this.userName = userName;
       this.password = password;
       this.email = email;
       this.amount = amount;
       this.deposits = deposits;
    }
   
     @Id 
    @Column(name="Id", unique=true, nullable=false)
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    
    @Column(name="userName", nullable=false)
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    @Column(name="password", nullable=false)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="email", nullable=false)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="amount", nullable=false)
    public long getAmount() {
        return this.amount;
    }
    
    public void setAmount(long amount) {
        this.amount = amount;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<Deposit> getDeposits() {
        return this.deposits;
    }
    
    public void setDeposits(Set<Deposit> deposits) {
        this.deposits = deposits;
    }




}

