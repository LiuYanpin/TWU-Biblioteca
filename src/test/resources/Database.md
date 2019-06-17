## Q1:
- Who checked out the book 'The Hobbit’?
```sqlite
select m.name from `member` as m 
where m.id = (select member_id from checkout_item where book_id = (
  select id from book where title = 'The Hobbit'
));
```
- Answer: Anand Beck
## Q2
- How many people have not checked out anything?
```sqlite
select count(id) from `member`
where id not in (
  select member_id from checkout_item 
);
```
- Answer: 37

## Q3
- What books and movies aren't checked out?

```sqlite
select * from book
where id NOT IN (
  select book_id from checkout_item where book_id not null 
);
```
- Answer: Book
```
2|Fellowship of the Ring
6|1984
7|Tom Sawyer
8|Catcher in the Rye
9|To Kill a Mockingbird
10|Domain Driven Design
```
---
```sqlite
select * from movie
where id NOT IN (
  select movie_id from checkout_item where movie_id not null 
);

```
- Answer: Movie
```
6|Thin Red Line
7|Crouching Tiger, Hidden Dragon
8|Lawrence of Arabia
9|Office Space
```

## Q4:
Add the book 'The Pragmatic Programmer',   
and add yourself as a member.   
Check out 'The Pragmatic Programmer'.   
Use your query from question 1 to verify that you have checked it out.   
Also, provide the SQL used to update the database.  
```sqlite
insert into book(id, title) values ('11', 'The Pragmatic Programmer');
insert into member(id, name) values ('43', 'LiuYanping');
insert into checkout_item(member_id, book_id, movie_id) values ('43', '11', null);
select m.name from `member` as m 
where m.id = (select member_id from checkout_item where book_id = (
  select id from book where title = 'The Pragmatic Programmer'
));

```

- sudo chown user biblioteca.sqlite


## Q5
- Who has checked out more that 1 item? 
Tip: Research the GROUP BY syntax.

```sqlite
select member_id, count(member_id) from checkout_item
group by member_id;

```
- Answer: 1:Anand Beck, 6:Frank Smith
```
1|3
2|1
6|3
7|1
8|1
43|1
```