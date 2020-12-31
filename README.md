# evented-url

## Notes
### Install Helm
[Follow their instructions...](https://helm.sh/docs/intro/install/)

### Add bitnami
```shell script
helm repo add bitnami https://charts.bitnami.com/bitnami
```

### Run Mongo

Note that this chart and containerization is not my own.  Please refer to originator [here](https://github.com/bitnami/charts/tree/master/bitnami/mongodb).

Feel free to use other Mongo installations.  Instructions and dependency included for the sake of getting a developer started quickly.


#### Install Mongo

```shell script
helm install mongodb bitnami/mongodb
```

#### Port Forwarding
```shell script
kubectl port-forward service/mongodb 27017
```

### Extract Password
```shell script
kubectl get secret --namespace default mongodb -o jsonpath="{.data.mongodb-root-password}" | base64 --decode
```

```powershell script
$encoded = kubectl get secret --namespace default mongodb -o jsonpath="{.data.mongodb-root-password}" 
[System.Text.Encoding]::ASCII.GetString([System.Convert]::FromBase64String($encoded));
```

### Set Password in callers


### Run Rabbit
Note that this chart and containerization is not my own.  Please refer to originator [here](https://github.com/bitnami/charts/tree/master/bitnami/rabbitmq).

Feel free to use other Rabbit installations.  Instructions and dependency included for the sake of getting a developer started quickly.

#### Install Rabbit
```shell script
helm install rabbitmq bitnami/rabbitmq
```

### Extract Password
```shell script
echo "Username      : user"
echo "Password      : $(kubectl get secret --namespace default rabbitmq -o jsonpath="{.data.rabbitmq-password}" | base64 --decode)"
echo "ErLang Cookie : $(kubectl get secret --namespace default rabbitmq -o jsonpath="{.data.rabbitmq-erlang-cookie}" | base64 --decode)"
```

### Set Password in callers

#### Port Forwarding
```shell script
kubectl port-forward service/rabbitmq 5672
```

### Run Consul 
```shell script
helm install -f "config.yaml" consul hashicorp/consul --set global.name=consul
```

```yaml
#Config.yaml
---
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
#### Key: `bookmarks-command-handler`
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

#### Key: `bookmarks-query-handler`
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
docker build --tag name.benjaminabbitt.evented.wwwwwh.url.businessLogic .\BusinessLogic
```

### Build Projection image
Note: This uses the shared build image, above
```shell script
docker build --tag name.benjaminabbitt.evented.wwwwwh.url.projection .\Projection
```

##Run Support

### Command Handler

#### Test Command Handler
```shell script
docker run evented-commandhandler /bin/grpc_health_probe --addr=EXTERNAL_IP:1747
```

###Install Command Handler
```
helm install --generate-name  .\evtd-ch\ -f C:\workspace\URL\config\businesslogic.yaml -f C:\workspace\URL\config\domain.yaml -f C:\workspace\URL\config\site.yam
l --dry-run
```




## Deprecated Config/Data
```shell script
docker run -p 4369:4369 -p 5671:5671 -p 5672:5672 -p 25672:25672 rabbitmq:3.8.3-management-alpine
```
```shell script
docker run -p 27017:27017 mongo:4.2.6-bionic
```

##Verification and Manual Testing with Busybox on K8s
```
from: https://containers.goffinet.org/kubernetes-the-hard-way/docs/12-dns-addon.html
Verification

Create a busybox deployment:

kubectl run busybox --image=busybox:1.28 --command -- sleep 3600

List the pod created by the busybox deployment:

kubectl get pods -l run=busybox

    output

NAME                      READY   STATUS    RESTARTS   AGE
busybox-bd8fb7cbd-vflm9   1/1     Running   0          10s

Retrieve the full name of the busybox pod:

POD_NAME=$(kubectl get pods -l run=busybox -o jsonpath="{.items[0].metadata.name}")

Execute a DNS lookup for the kubernetes service inside the busybox pod:

kubectl exec -ti $POD_NAME -- nslookup kubernetes

    output

Server:    10.32.0.10
Address 1: 10.32.0.10 kube-dns.kube-system.svc.cluster.local

Name:      kubernetes
Address 1: 10.32.0.1 kubernetes.default.svc.cluster.local

```