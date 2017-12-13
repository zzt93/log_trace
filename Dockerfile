FROM 192.168.1.202/library/basejava
ADD ./filebeat-5.6.1-amd64.deb filebeat.deb
RUN dpkg -i /filebeat.deb
ADD ./filebeat.yml /etc/filebeat/
RUN service filebeat start