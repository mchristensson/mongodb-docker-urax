FROM nginx:alpine

LABEL maintainer="Mac Urax"

WORKDIR /etc/nginx
COPY ./nginx.conf ./conf.d/default.conf
#EXPOSE 80
ENTRYPOINT [ "nginx" ]
CMD [ "-g", "daemon off;" ]