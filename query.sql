/*    ==Scripting Parameters==

    Source Server Version : SQL Server 2016 (13.0.4001)
    Source Database Engine Edition : Microsoft SQL Server Enterprise Edition
    Source Database Engine Type : Standalone SQL Server

    Target Server Version : SQL Server 2017
    Target Database Engine Edition : Microsoft SQL Server Standard Edition
    Target Database Engine Type : Standalone SQL Server
*/
USE [scissorrockpaper]
GO
/****** Object:  Table [dbo].[Card]    Script Date: 1/12/2017 9:04:41 PM ******/
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
/****** Object:  Table [dbo].[Deposit]    Script Date: 1/12/2017 9:04:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Deposit](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[IdUser] [bigint] NOT NULL,
	[IdCard] [bigint] NOT NULL,
	[Serial] [nchar](15) NOT NULL,
 CONSTRAINT [PK_Deposit] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 1/12/2017 9:04:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[userName] [nchar](15) NOT NULL,
	[password] [nchar](20) NOT NULL,
	[email] [nchar](20) NOT NULL,
	[amount] [bigint] NOT NULL,
 CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED 
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

INSERT [dbo].[Deposit] ([Id], [IdUser], [IdCard], [Serial]) VALUES (1, 1, 2, N'12312312312    ')
SET IDENTITY_INSERT [dbo].[Deposit] OFF
SET IDENTITY_INSERT [dbo].[User] ON 

INSERT [dbo].[User] ([Id], [userName], [password], [email], [amount]) VALUES (1, N'minhlk         ', N'123456              ', N'minhlk@gmail.com    ', 180)
INSERT [dbo].[User] ([Id], [userName], [password], [email], [amount]) VALUES (2, N'minh           ', N'123456              ', N'minh@gmail.com      ', 120)
INSERT [dbo].[User] ([Id], [userName], [password], [email], [amount]) VALUES (4, N'minhlkz        ', N'123456              ', N'minh@m.com          ', 90)
SET IDENTITY_INSERT [dbo].[User] OFF
ALTER TABLE [dbo].[User] ADD  CONSTRAINT [DF_user_amount]  DEFAULT ((0)) FOR [amount]
GO
ALTER TABLE [dbo].[Deposit]  WITH CHECK ADD  CONSTRAINT [FK_Deposit_Card] FOREIGN KEY([IdCard])
REFERENCES [dbo].[Card] ([Id])
GO
ALTER TABLE [dbo].[Deposit] CHECK CONSTRAINT [FK_Deposit_Card]
GO
ALTER TABLE [dbo].[Deposit]  WITH CHECK ADD  CONSTRAINT [FK_Deposit_user] FOREIGN KEY([IdUser])
REFERENCES [dbo].[User] ([Id])
GO
ALTER TABLE [dbo].[Deposit] CHECK CONSTRAINT [FK_Deposit_user]
GO
