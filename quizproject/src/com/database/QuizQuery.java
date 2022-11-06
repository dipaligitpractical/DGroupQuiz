package com.database;

public class QuizQuery {
/*
 *data created
	create database quizdb;
	
	//use database
	use quizdb;

	//used Registration table
	create table studentRegistration(sId int not null auto_increment,sName varchar(255)not null,
	sLastName varchar(255) not null,sRollNo varchar(255) not null ,primary key(sId));
	
	//Student result table
	create table studentResults(Id int primary key not null,sFullName varchar(255),sScore int ,foreign key( Id)references studentRegistration(sId));

	//Question table
	create table questions(queNo int not null auto_increment,question varchar(255),
	op1 varchar(255),op2 varchar(255),op3 varchar(255) ,op4 varchar(255),correctAns varchar(255),primary key(queNo));

	//student login table
	create table studentLoginDetails(sId int,userName varchar(255),sPassword varchar(255),foreign key(sId) references studentRegistration(sId));

	//insert data into question table
	 * 
	insert into questions(question,op1,op2,op3,op4, correctAns)values
	("Number of primitive datatype in java","5","6","7","8","D"),
	("Size of int primitive datatype in java","4","3","2","1","A"),
	("Thread Class method","start()","run()","sleep","all of these","D"),
	("Types of Exception","checked","Unchecked","Error","all of these","D"),
	("Java was First released in ?","1995","1991","1890","1992","A"),
	("Collection sub interface is?","list","array","map","all of these","A"),
	(" list child classes are ?","ArrayList","LinkedList","Vector","All of these","D"),
	("lagacy classes","vector","stack","hashtable","all of these","D"),
	("non primitive data type","class","int","string","A&C","D"),
	("DML command","update","delete","drop","all of these","D");
*/
}
