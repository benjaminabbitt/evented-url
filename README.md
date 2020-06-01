# evented-url

## Notes
### Install Helm
```shell script

```
### Add bitnami
```shell script
helm repo add bitnami https://charts.bitnami.com/bitnami
```

### Run Mongo
```shell script
helm install mongodb bitnami/mongodb
```



### Run Rabbit (with debugging/management)
```shell script
helm install rabbitmq bitnami/rabbitmq
```


### Run Consul 
```shell script
helm install -f "config.yaml" consul hashicorp/consul --set global.name=consul
```

`Config.yaml`
```yaml
server:
  replicas: 1
  bootstrapExpect: 1
  disruptionBudget:
    enabled: true
    maxUnavailable: 0

ui:
  service:
    type: 'LoadBalancer'
    
connectInject:
  enabled: true

client:
  enabled: true
```

### Load Configuration
Load configuration for the provided handlers and coordinators into Consul K/V.
#### `bookmarks-command-handler`
TODO: remove urls from this configuration file/value and rely on Consul service location by default.
```yaml
---
port: 1747
domain: domainA
business:
  url: localhost:1748
  #sync:
  #projectors:
  #  - localhost:8011
  #  - localhost:8081
#  sagas:
#    domainB:
#      url: localhost:8021
eventStore:
  type: mongodb
  mongodb:
    url: mongodb://localhost:27017
    database: event
    collection: sequence
snapshotStore:
  type: mongodb
  mongodb:
    url: mongodb://localhost:27017
    database: snapshot
transport:
  type: amqp
  amqp:
    url: amqp://guest:guest@localhost:5672/
    exchange: domainAExchange
```

#### `bookmarks-query-handler`
TODO: remove urls from this configuration file/value and rely on Consul service location by default.
```yaml
---
port: 8002
database:
  url: mongodb://localhost:27017
  name: evented
  collection: events
targetSize: 10000
```

### Consul access from host computer (UI and/or development access)
```shell script
kubectl port-forward service/consul-server 8500:8500
```

### Build Shared Build image
```shell script
docker build --tag name.benjaminabbitt.evented.wwwwwh.url-build .
```
TODO: wrap this chain of docker builds into some build mechanism (gradle or yeoman)

### Build Business image
Note: This uses the shared build image, above
```shell script
docker build --tag name.benjaminabbitt.evented.wwwwwh.url.business .\Business
```

### Build Projection image
Note: This uses the shared build image, above
```shell script
docker build --tag name.benjaminabbitt.evented.wwwwwh.url.projection .\Projection
```

## Deprecated Config/Data
```shell script
docker run -p 4369:4369 -p 5671:5671 -p 5672:5672 -p 25672:25672 rabbitmq:3.8.3-management-alpine
```
```shell script
docker run -p 27017:27017 mongo:4.2.6-bionic
```
