####In Windows rabbitmq.conf file can be created at

````
%APPDATA% usually expands to C:\Users\%USERNAME%\AppData\Roaming or similar.
````

In Linux

```/etc/rabbitmq/```


### rabbitmq.conf file SSL conf

```
ssl_options.cacertfile = C:\Users\ankit.patwa\AppData\Roaming\RabbitMQ\cacert.pem
ssl_options.certfile = C:\Users\ankit.patwa\AppData\Roaming\RabbitMQ\cert.pem
ssl_options.keyfile = C:\Users\ankit.patwa\AppData\Roaming\RabbitMQ\key.pem
ssl_options.verify = verify_none
ssl_options.fail_if_no_peer_cert = true
listeners.ssl.default = 5671
```


#### Enable Managemnet pluging to access rabbbitmq from browser
```rabbitmq-plugins enable rabbitmq_management```

##### How to set admistrator username password in rabbitmq

```
sudo rabbitmqctl add_user admin admin@1234
sudo rabbitmqctl set_user_tags 'admin' administrator
sudo rabbitmqctl set_permissions -p / 'admin' ".*" ".*" ".*"
```
