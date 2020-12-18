FROM mongo
COPY start.sh /docker-entrypoint-initdb.d/
COPY ./database.zip /docker-entrypoint-initdb.d/
RUN chmod -R 777 /docker-entrypoint-initdb.d/database.zip
RUN chmod 777 /docker-entrypoint-initdb.d/start.sh
