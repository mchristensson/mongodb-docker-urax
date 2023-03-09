### Run db container
> The following starts the container from our image
> * Using `-d` for starting in detached mode
> * argument `MYSQL_ROOT_PASSWORD` defines mysql process password 
> * argument `MYSQL_USER` defines jdbc-connection username 
> * argument `MYSQL_PASSWORD` defines jdbc-connection user password 
```
$ docker run -p 3306:3306 -d -e MYSQL_ROOT_PASSWORD=userpass -e MYSQL_USER=uraxmysqluser -e MYSQL_PASSWORD=uraxmysqlpw uraxdb:0.0.1
```

#### Try accessing database
```
sh-4.4# mysql -p {DB_SCHEMA_NAME}
Enter password: {MYSQL_ROOT_PASSWORD}
```

### Add Adminer-image for handshaking and verification
In the `docker-compose.yml` file, you may add the image `Adminer` in order to inspect the MySql container.
```
  adminer:
    image: adminer
    restart: always
    ports:
      - 9090:8080
```