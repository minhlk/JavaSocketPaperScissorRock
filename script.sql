/*    ==Scripting Parameters==

    Source Server Version : SQL Server 2016 (13.0.4001)
    Source Database Engine Edition : Microsoft SQL Server Enterprise Edition
    Source Database Engine Type : Standalone SQL Server

    Target Server Version : SQL Server 2017
    Target Database Engine Edition : Microsoft SQL Server Standard Edition
    Target Database Engine Type : Standalone SQL Server
*/
USE [SRP]
GO
/****** Object:  Table [dbo].[Card]    Script Date: 16/12/2017 8:54:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Card](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[CardName] [nvarchar](25) NOT NULL,
 CONSTRAINT [PK_Card] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Deposit]    Script Date: 16/12/2017 8:54:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Deposit](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[IdPlayer] [bigint] NOT NULL,
	[IdCard] [bigint] NOT NULL,
	[Serial] [nchar](15) NOT NULL,
	[Create_time] [date] NOT NULL,
 CONSTRAINT [PK_Deposit] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Player]    Script Date: 16/12/2017 8:54:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Player](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[playerName] [nchar](15) NOT NULL,
	[password] [nchar](20) NOT NULL,
	[email] [nchar](20) NOT NULL,
	[amount] [bigint] NOT NULL,
 CONSTRAINT [PK_player] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Card] ON 

INSERT [dbo].[Card] ([Id], [CardName]) VALUES (1, N'Viettel')
INSERT [dbo].[Card] ([Id], [CardName]) VALUES (2, N'Mobifone')
INSERT [dbo].[Card] ([Id], [CardName]) VALUES (3, N'Docomo')
INSERT [dbo].[Card] ([Id], [CardName]) VALUES (4, N'Vinaphone')
SET IDENTITY_INSERT [dbo].[Card] OFF
SET IDENTITY_INSERT [dbo].[Deposit] ON 

INSERT [dbo].[Deposit] ([Id], [IdPlayer], [IdCard], [Serial], [Create_time]) VALUES (1, 1, 2, N'12312312312    ', CAST(N'2017-12-16' AS Date))
SET IDENTITY_INSERT [dbo].[Deposit] OFF
SET IDENTITY_INSERT [dbo].[Player] ON 

INSERT [dbo].[Player] ([Id], [playerName], [password], [email], [amount]) VALUES (1, N'minhlk         ', N'123456              ', N'minhlk@gmail.com    ', 180)
INSERT [dbo].[Player] ([Id], [playerName], [password], [email], [amount]) VALUES (2, N'minh           ', N'123456              ', N'minh@gmail.com      ', 90)
INSERT [dbo].[Player] ([Id], [playerName], [password], [email], [amount]) VALUES (4, N'minhlkz        ', N'123456              ', N'minh@m.com          ', 90)
SET IDENTITY_INSERT [dbo].[Player] OFF
ALTER TABLE [dbo].[Deposit] ADD  CONSTRAINT [DF_Deposit_Create_time]  DEFAULT (getdate()) FOR [Create_time]
GO
ALTER TABLE [dbo].[Player] ADD  CONSTRAINT [DF_player_amount]  DEFAULT ((0)) FOR [amount]
GO
ALTER TABLE [dbo].[Deposit]  WITH CHECK ADD  CONSTRAINT [FK_Deposit_Card] FOREIGN KEY([IdCard])
REFERENCES [dbo].[Card] ([Id])
GO
ALTER TABLE [dbo].[Deposit] CHECK CONSTRAINT [FK_Deposit_Card]
GO
ALTER TABLE [dbo].[Deposit]  WITH CHECK ADD  CONSTRAINT [FK_Deposit_player] FOREIGN KEY([IdPlayer])
REFERENCES [dbo].[Player] ([Id])
GO
ALTER TABLE [dbo].[Deposit] CHECK CONSTRAINT [FK_Deposit_player]
GO
