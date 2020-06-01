# evented-url

## Notes
### Install Helm
[Follow their instructions...](https://helm.sh/docs/intro/install/)

### Add bitnami
```shell script
helm repo add bitnami https://charts.bitnami.com/bitnami
```

### Run Mongo

#### Configure Mongo
Before running the helm install, copy/paste out this values.yaml file, then edit appropriately to your environment.  For development, passwords should be set.

Note: the [origin](https://github.com/bitnami/charts/blob/master/bitnami/mongodb/values.yaml) of this file is Bitnami.
#####`values.yaml`
```yaml
## Global Docker image parameters
## Please, note that this will override the image parameters, including dependencies, configured to use the global value
## Current available global Docker image parameters: imageRegistry and imagePullSecrets
##
# global:
#   imageRegistry: myRegistryName
#   imagePullSecrets:
#     - myRegistryKeySecretName
#   storageClass: myStorageClass
## Override the namespace for resource deployed by the chart, but can itself be overridden by the local namespaceOverride
#   namespaceOverride: my-global-namespace

image:
  ## Bitnami MongoDB registry
  ##
  registry: docker.io
  ## Bitnami MongoDB image name
  ##
  repository: bitnami/mongodb
  ## Bitnami MongoDB image tag
  ## ref: https://hub.docker.com/r/bitnami/mongodb/tags/
  ##
  tag: 4.2.7-debian-10-r9
  ## Specify a imagePullPolicy
  ## ref: http://kubernetes.io/docs/user-guide/images/#pre-pulling-images
  ##
  pullPolicy: IfNotPresent
  ## Optionally specify an array of imagePullSecrets.
  ## Secrets must be manually created in the namespace.
  ## ref: https://kubernetes.io/docs/tasks/configure-pod-container/pull-image-private-registry/
  ##
  # pullSecrets:
  #   - myRegistryKeySecretName

  ## Set to true if you would like to see extra information on logs
  ## It turns on Bitnami debugging in minideb-extras-base
  ## ref:  https://github.com/bitnami/minideb-extras-base
  debug: false

## String to partially override mongodb.fullname template (will maintain the release name)
##
# nameOverride:

## String to fully override mongodb.fullname template
##
# fullnameOverride:

serviceAccount:
  # Specifies whether a ServiceAccount should be created
  create: true
  # The name of the ServiceAccount to use.
  # If not set and create is true, a name is generated using the fullname template
  name:

## Init containers parameters:
## volumePermissions: Change the owner and group of the persistent volume mountpoint to runAsUser:fsGroup values from the securityContext section.
##
volumePermissions:
  enabled: false
  image:
    registry: docker.io
    repository: bitnami/minideb
    tag: buster
    pullPolicy: Always
    ## Optionally specify an array of imagePullSecrets.
    ## Secrets must be manually created in the namespace.
    ## ref: https://kubernetes.io/docs/tasks/configure-pod-container/pull-image-private-registry/
    ##
    # pullSecrets:
    #   - myRegistryKeySecretName
  resources: {}

## Enable authentication
## ref: https://docs.mongodb.com/manual/tutorial/enable-authentication/
#
usePassword: true
# existingSecret: name-of-existing-secret

## MongoDB admin password
## ref: https://github.com/bitnami/bitnami-docker-mongodb/blob/master/README.md#setting-the-root-password-on-first-run
##
# mongodbRootPassword:

## MongoDB custom user and database
## ref: https://github.com/bitnami/bitnami-docker-mongodb/blob/master/README.md#creating-a-user-and-database-on-first-run
##
# mongodbUsername: username
# mongodbPassword: password
# mongodbDatabase: database

## Whether enable/disable IPv6 on MongoDB
## ref: https://github.com/bitnami/bitnami-docker-mongodb/blob/master/README.md#enabling/disabling-ipv6
##
mongodbEnableIPv6: false

## Whether enable/disable DirectoryPerDB on MongoDB
## ref: https://github.com/bitnami/bitnami-docker-mongodb/blob/master/README.md#enabling/disabling-directoryperdb
##
mongodbDirectoryPerDB: false

## MongoDB System Log configuration
## ref: https://github.com/bitnami/bitnami-docker-mongodb#configuring-system-log-verbosity-level
##
mongodbSystemLogVerbosity: 0
mongodbDisableSystemLog: false

## MongoDB additional command line flags
##
## Can be used to specify command line flags, for example:
##
## mongodbExtraFlags:
##  - "--wiredTigerCacheSizeGB=2"
mongodbExtraFlags: []

## Pod Security Context
## ref: https://kubernetes.io/docs/tasks/configure-pod-container/security-context/
##
securityContext:
  enabled: true
  fsGroup: 1001
  runAsUser: 1001

## Kubernetes Cluster Domain
clusterDomain: cluster.local

## Kubernetes service type
service:
  ## Specify an explicit service name.
  # name: svc-mongo
  ## Provide any additional annotations which may be required.
  ## The value is evaluated as a template, so, for example, the value can depend on .Release or .Chart
  annotations: {}
  type: ClusterIP
  # clusterIP: None
  port: 27017

  ## Specify the nodePort value for the LoadBalancer and NodePort service types.
  ## ref: https://kubernetes.io/docs/concepts/services-networking/service/#type-nodeport
  ##
  # nodePort:

  ## Specify the externalIP value ClusterIP service type.
  ## ref: https://kubernetes.io/docs/concepts/services-networking/service/#external-ips
  # externalIPs: []

  ## Specify the loadBalancerIP value for LoadBalancer service types.
  ## ref: https://kubernetes.io/docs/concepts/services-networking/service/#loadbalancer
  ##
  # loadBalancerIP:

  ## Specify the loadBalancerSourceRanges value for LoadBalancer service types.
  ## ref: https://kubernetes.io/docs/tasks/access-application-cluster/configure-cloud-provider-firewall/#restrict-access-for-loadbalancer-service
  ##
  # loadBalancerSourceRanges: []

# Add custom extra environment variables to all the MongoDB containers
# extraEnvVars:

## Use StatefulSet instead of Deployment when deploying standalone
useStatefulSet: false

## Setting up replication
## ref: https://github.com/bitnami/bitnami-docker-mongodb#setting-up-a-replication
#
replicaSet:
  ## Whether to create a MongoDB replica set for high availability or not
  enabled: false
  useHostnames: true

  ## Name of the replica set
  ##
  name: rs0

  ## Key used for replica set authentication
  ##
  # key: key

  ## Number of replicas per each node type
  ##
  replicas:
    secondary: 1
    arbiter: 1

  ## Pod Disruption Budget
  ## ref: https://kubernetes.io/docs/concepts/workloads/pods/disruptions/
  pdb:
    enabled: true
    minAvailable:
      primary: 1
      secondary: 1
      arbiter: 1
      # maxUnavailable:
      # primary: 1
      # secondary: 1
      # arbiter: 1

# Annotations to be added to the deployment or statefulsets
annotations: {}

# Additional labels to apply to the deployment or statefulsets
labels: {}

# Annotations to be added to MongoDB pods
podAnnotations: {}

# Additional pod labels to apply
podLabels: {}

## Use an alternate scheduler, e.g. "stork".
## ref: https://kubernetes.io/docs/tasks/administer-cluster/configure-multiple-schedulers/
##
# schedulerName:

## Configure resource requests and limits
## ref: http://kubernetes.io/docs/user-guide/compute-resources/
##
resources: {}
# Define separate resources per arbiter, which are less then primary or secondary
# used only when replica set is enabled
resourcesArbiter: {}
# limits:
#   cpu: 500m
#   memory: 512Mi
# requests:
#   cpu: 100m
#   memory: 256Mi

## Pod priority
## https://kubernetes.io/docs/concepts/configuration/pod-priority-preemption/
# priorityClassName: ""

## Node selector
## ref: https://kubernetes.io/docs/concepts/configuration/assign-pod-node/#nodeselector
nodeSelector: {}

## Define Separate nodeSelector for secondaries
## ref: https://kubernetes.io/docs/concepts/configuration/assign-pod-node/#nodeselector
nodeSelectorSecondary: {}

## Define Separate nodeSelector for arbiter
## ref: https://kubernetes.io/docs/concepts/configuration/assign-pod-node/#nodeselector
nodeSelectorArbiter: {}

## Affinity
## ref: https://kubernetes.io/docs/concepts/configuration/assign-pod-node/#affinity-and-anti-affinity
affinity: {}
# Define separate affinity for arbiter pod
affinityArbiter: {}

## Tolerations
## ref: https://kubernetes.io/docs/concepts/configuration/taint-and-toleration/
tolerations: []

## updateStrategy for MongoDB Primary, Secondary and Arbitrer statefulsets
## ref: https://kubernetes.io/docs/concepts/workloads/controllers/statefulset/#update-strategies
updateStrategy:
  type: RollingUpdate

## Add sidecars to the pod
##
## For example:
## sidecars:
##   - name: your-image-name
##     image: your-image
##     imagePullPolicy: Always
##     ports:
##       - name: portname
##         containerPort: 1234
sidecars: []
## Array to add extra volumes
##
extraVolumes: []
## Array to add extra mounts (normally used with extraVolumes)
##
extraVolumeMounts: []

## Add sidecars to the arbiter pod
# used only when replica set is enabled
##
## For example:
## sidecars:
##   - name: your-image-name
##     image: your-image
##     imagePullPolicy: Always
##     ports:
##       - name: portname
##         containerPort: 1234
sidecarsArbiter: []
## Array to add extra volumes to the arbiter
# used only when replica set is enabled
##
extraVolumesArbiter: []
## Array to add extra mounts (normally used with extraVolumes) to the arbiter
# used only when replica set is enabled
##
extraVolumeMountsArbiter: []

## Enable persistence using Persistent Volume Claims
## ref: http://kubernetes.io/docs/user-guide/persistent-volumes/
##
persistence:
  enabled: true
  ## A manually managed Persistent Volume and Claim
  ## Requires persistence.enabled: true
  ## If defined, PVC must be created manually before volume will be bound
  ##
  # existingClaim:

  ## The path the volume will be mounted at, useful when using different
  ## MongoDB images.
  ##
  mountPath: /bitnami/mongodb

  ## The subdirectory of the volume to mount to, useful in dev environments
  ## and one PV for multiple services.
  ##
  subPath: ""

  ## mongodb data Persistent Volume Storage Class
  ## If defined, storageClassName: <storageClass>
  ## If set to "-", storageClassName: "", which disables dynamic provisioning
  ## If undefined (the default) or set to null, no storageClassName spec is
  ##   set, choosing the default provisioner.  (gp2 on AWS, standard on
  ##   GKE, AWS & OpenStack)
  ##
  # storageClass: "-"
  # storageClassSecondary: "-"
  accessModes:
    - ReadWriteOnce
  size: 8Gi
  annotations: {}

## Configure the ingress resource that allows you to access the
## MongoDB installation. Set up the URL
## ref: http://kubernetes.io/docs/user-guide/ingress/
##
ingress:
  ## Set to true to enable ingress record generation
  enabled: false

  ## Set this to true in order to add the corresponding annotations for cert-manager
  certManager: false

  ## Ingress annotations done as key:value pairs
  ## For a full list of possible ingress annotations, please see
  ## ref: https://github.com/kubernetes/ingress-nginx/blob/master/docs/user-guide/nginx-configuration/annotations.md
  ##
  ## If tls is set to true, annotation ingress.kubernetes.io/secure-backends: "true" will automatically be set
  ## If certManager is set to true, annotation kubernetes.io/tls-acme: "true" will automatically be set
  annotations:
  #  kubernetes.io/ingress.class: nginx

  ## The list of hostnames to be covered with this ingress record.
  ## Most likely this will be just one host, but in the event more hosts are needed, this is an array
  hosts:
    - name: mongodb.local
      path: /

  ## The tls configuration for the ingress
  ## see: https://kubernetes.io/docs/concepts/services-networking/ingress/#tls
  tls:
    - hosts:
        - mongodb.local
      secretName: mongodb.local-tls

  secrets:
  ## If you're providing your own certificates, please use this to add the certificates as secrets
  ## key and certificate should start with -----BEGIN CERTIFICATE----- or
  ## -----BEGIN RSA PRIVATE KEY-----
  ##
  ## name should line up with a tlsSecret set further up
  ## If you're using cert-manager, this is unneeded, as it will create the secret for you if it is not set
  ##
  ## It is also possible to create and manage the certificates outside of this helm chart
  ## Please see README.md for more information
  # - name: airflow.local-tls
  #   key:
  #   certificate:

## Configure the options for init containers to be run before the main app containers
## are started. All init containers are run sequentially and must exit without errors
## for the next one to be started.
## ref: https://kubernetes.io/docs/concepts/workloads/pods/init-containers/
# extraInitContainers: |
#   - name: do-something
#     image: busybox
#     command: ['do', 'something']

## Configure extra options for liveness and readiness probes
## ref: https://kubernetes.io/docs/tasks/configure-pod-container/configure-liveness-readiness-probes/#configure-probes)
livenessProbe:
  enabled: true
  initialDelaySeconds: 30
  periodSeconds: 10
  timeoutSeconds: 5
  failureThreshold: 6
  successThreshold: 1
readinessProbe:
  enabled: true
  initialDelaySeconds: 5
  periodSeconds: 10
  timeoutSeconds: 5
  failureThreshold: 6
  successThreshold: 1

# Define custom config map with init scripts
initConfigMap: {}
#  name: "init-config-map"

## Entries for the MongoDB config file. For documentation of all options, see:
##   http://docs.mongodb.org/manual/reference/configuration-options/
##
configmap:
#  # where and how to store data.
#  storage:
#    dbPath: /bitnami/mongodb/data/db
#    journal:
#      enabled: true
#    directoryPerDB: false
#  # where to write logging data.
#  systemLog:
#    destination: file
#    quiet: false
#    logAppend: true
#    logRotate: reopen
#    path: /opt/bitnami/mongodb/logs/mongodb.log
#    verbosity: 0
#  # network interfaces
#  net:
#    port: 27017
#    unixDomainSocket:
#      enabled: true
#      pathPrefix: /opt/bitnami/mongodb/tmp
#    ipv6: false
#    bindIpAll: true
#  # replica set options
#  #replication:
#    #replSetName: replicaset
#    #enableMajorityReadConcern: true
#  # process management options
#  processManagement:
#     fork: false
#     pidFilePath: /opt/bitnami/mongodb/tmp/mongodb.pid
#  # set parameter options
#  setParameter:
#     enableLocalhostAuthBypass: true
#  # security options
#  security:
#    authorization: disabled
#    #keyFile: /opt/bitnami/mongodb/conf/keyfile

## Prometheus Exporter / Metrics
##
metrics:
  enabled: false

  image:
    registry: docker.io
    repository: bitnami/mongodb-exporter
    tag: 0.11.0-debian-10-r40
    pullPolicy: IfNotPresent
    ## Optionally specify an array of imagePullSecrets.
    ## Secrets must be manually created in the namespace.
    ## ref: https://kubernetes.io/docs/tasks/configure-pod-container/pull-image-private-registry/
    ##
    # pullSecrets:
    #   - myRegistryKeySecretName

  ## String with extra arguments to the metrics exporter
  ## ref: https://github.com/percona/mongodb_exporter/blob/master/mongodb_exporter.go
  extraArgs: ""

  ## Metrics exporter resource requests and limits
  ## ref: http://kubernetes.io/docs/user-guide/compute-resources/
  ##
  # resources: {}

  ## Metrics exporter liveness and readiness probes
  ## ref: https://kubernetes.io/docs/tasks/configure-pod-container/configure-liveness-readiness-probes/#configure-probes)
  livenessProbe:
    enabled: false
    initialDelaySeconds: 15
    periodSeconds: 5
    timeoutSeconds: 5
    failureThreshold: 3
    successThreshold: 1
  readinessProbe:
    enabled: false
    initialDelaySeconds: 5
    periodSeconds: 5
    timeoutSeconds: 1
    failureThreshold: 3
    successThreshold: 1

  ## Metrics exporter pod Annotation
  podAnnotations:
    prometheus.io/scrape: "true"
    prometheus.io/port: "9216"

  ## Prometheus Service Monitor
  ## ref: https://github.com/coreos/prometheus-operator
  ##      https://github.com/coreos/prometheus-operator/blob/master/Documentation/api.md
  serviceMonitor:
    ## If the operator is installed in your cluster, set to true to create a Service Monitor Entry
    enabled: false

    ## Specify a namespace if needed
    # namespace: monitoring

    ## Used to pass Labels that are used by the Prometheus installed in your cluster to select Service Monitors to work with
    ## ref: https://github.com/coreos/prometheus-operator/blob/master/Documentation/api.md#prometheusspec
    additionalLabels: {}

    ## Specify Metric Relabellings to add to the scrape endpoint
    ## ref: https://github.com/coreos/prometheus-operator/blob/master/Documentation/api.md#endpoint
    # relabellings:

    alerting:
      ## Define individual alerting rules as required
      ## ref: https://github.com/coreos/prometheus-operator/blob/master/Documentation/api.md#rulegroup
      ##      https://prometheus.io/docs/prometheus/latest/configuration/alerting_rules/
      rules: {}

      ## Used to pass Labels that are used by the Prometheus installed in your cluster to select Prometheus Rules to work with
      ## ref: https://github.com/coreos/prometheus-operator/blob/master/Documentation/api.md#prometheusspec
      additionalLabels: {}
```

#### Install Mongo

```shell script
helm install -f values.yaml mongodb bitnami/mongodb
```

### Run Rabbit
Note: the [origin](https://github.com/bitnami/charts/blob/master/bitnami/rabbitmq/values.yaml) of this configuration file is Bitnami.
```shell script
## Global Docker image parameters
## Please, note that this will override the image parameters, including dependencies, configured to use the global value
## Current available global Docker image parameters: imageRegistry and imagePullSecrets
##
# global:
#   imageRegistry: myRegistryName
#   imagePullSecrets:
#     - myRegistryKeySecretName
#   storageClass: myStorageClass

## Bitnami RabbitMQ image version
## ref: https://hub.docker.com/r/bitnami/rabbitmq/tags/
##
image:
  registry: docker.io
  repository: bitnami/rabbitmq
  tag: 3.8.3-debian-10-r92

  ## set to true if you would like to see extra information on logs
  ## it turns BASH and NAMI debugging in minideb
  ## ref:  https://github.com/bitnami/minideb-extras/#turn-on-bash-debugging
  debug: false

  ## Specify a imagePullPolicy
  ## Defaults to 'Always' if image tag is 'latest', else set to 'IfNotPresent'
  ## ref: http://kubernetes.io/docs/user-guide/images/#pre-pulling-images
  ##
  pullPolicy: IfNotPresent
  ## Optionally specify an array of imagePullSecrets.
  ## Secrets must be manually created in the namespace.
  ## ref: https://kubernetes.io/docs/tasks/configure-pod-container/pull-image-private-registry/
  ##
  # pullSecrets:
  #   - myRegistryKeySecretName

## String to partially override rabbitmq.fullname template (will maintain the release name)
##
# nameOverride:

## String to fully override rabbitmq.fullname template
##
# fullnameOverride:

## Use an alternate scheduler, e.g. "stork".
## ref: https://kubernetes.io/docs/tasks/administer-cluster/configure-multiple-schedulers/
##
# schedulerName:

## does your cluster have rbac enabled? assume yes by default
rbacEnabled: true

## RabbitMQ should be initialized one by one when building cluster for the first time.
## Therefore, the default value of podManagementPolicy is 'OrderedReady'
## Once the RabbitMQ participates in the cluster, it waits for a response from another
## RabbitMQ in the same cluster at reboot, except the last RabbitMQ of the same cluster.
## If the cluster exits gracefully, you do not need to change the podManagementPolicy
## because the first RabbitMQ of the statefulset always will be last of the cluster.
## However if the last RabbitMQ of the cluster is not the first RabbitMQ due to a failure,
## you must change podManagementPolicy to 'Parallel'.
## ref : https://www.rabbitmq.com/clustering.html#restarting
##
podManagementPolicy: OrderedReady

## section of specific values for rabbitmq
rabbitmq:
  ## RabbitMQ application username
  ## ref: https://github.com/bitnami/bitnami-docker-rabbitmq#environment-variables
  ##
  username: user

  ## RabbitMQ application password
  ## ref: https://github.com/bitnami/bitnami-docker-rabbitmq#environment-variables
  ##
  # password:
  # existingPasswordSecret: name-of-existing-secret

  ## Erlang cookie to determine whether different nodes are allowed to communicate with each other
  ## ref: https://github.com/bitnami/bitnami-docker-rabbitmq#environment-variables
  ##
  # erlangCookie:
  # existingErlangSecret: name-of-existing-secret

  ## Node name to cluster with. e.g.: `clusternode@hostname`
  ## ref: https://github.com/bitnami/bitnami-docker-rabbitmq#environment-variables
  ##
  # rabbitmqClusterNodeName:

  ## Value for the RABBITMQ_LOGS environment variable
  ## ref: https://www.rabbitmq.com/logging.html#log-file-location
  ##
  logs: '-'

  ## RabbitMQ Max File Descriptors
  ## ref: https://github.com/bitnami/bitnami-docker-rabbitmq#environment-variables
  ## ref: https://www.rabbitmq.com/install-debian.html#kernel-resource-limits
  ##
  setUlimitNofiles: true
  ulimitNofiles: '65536'

  ## RabbitMQ maximum available scheduler threads and online scheduler threads. By default it will create a thread per CPU detected, with the following parameters you can tune it manually.
  ## ref: https://hamidreza-s.github.io/erlang/scheduling/real-time/preemptive/migration/2016/02/09/erlang-scheduler-details.html#scheduler-threads
  ## ref: https://github.com/bitnami/charts/issues/2189
  ##
  # maxAvailableSchedulers: 2
  # onlineSchedulers: 1

  ## Plugins to enable
  plugins: "rabbitmq_management rabbitmq_peer_discovery_k8s"

  ## Extra plugins to enable
  ## Use this instead of `plugins` to add new plugins
  extraPlugins: "rabbitmq_auth_backend_ldap"

  ## Clustering settings
  clustering:
    address_type: hostname
    k8s_domain: cluster.local
    ## Rebalance master for queues in cluster when new replica is created
    ## ref: https://www.rabbitmq.com/rabbitmq-queues.8.html#rebalance
    rebalance: false

  loadDefinition:
    enabled: false
    ## Can be templated if needed, e.g.
    # secretName: "{{ .Release.Name }}-load-definition"
    secretName: load-definition

  ## environment variables to configure rabbitmq
  ## ref: https://www.rabbitmq.com/configure.html#customise-environment
  env: {}

  ## Configuration file content: required cluster configuration
  ## Do not override unless you know what you are doing. To add more configuration, use `extraConfiguration` of `advancedConfiguration` instead
  configuration: |-
    ## Clustering
    cluster_formation.peer_discovery_backend  = rabbit_peer_discovery_k8s
    cluster_formation.k8s.host = kubernetes.default.svc.cluster.local
    cluster_formation.node_cleanup.interval = 10
    cluster_formation.node_cleanup.only_log_warning = true
    cluster_partition_handling = autoheal
    # queue master locator
    queue_master_locator=min-masters
    # enable guest user
    loopback_users.guest = false

  ## Configuration file content: extra configuration
  ## Use this instead of `configuration` to add more configuration
  extraConfiguration: |-
    #disk_free_limit.absolute = 50MB
    #management.load_definitions = /app/load_definition.json

  ## Configuration file content: advanced configuration
  ## Use this as additional configuraton in classic config format (Erlang term configuration format)
  ##
  ## If you set LDAP with TLS/SSL enabled and you are using self-signed certificates, uncomment these lines.
  ## advancedConfiguration: |-
  ##   [{
  ##     rabbitmq_auth_backend_ldap,
  ##     [{
  ##         ssl_options,
  ##         [{
  ##             verify, verify_none
  ##         }, {
  ##             fail_if_no_peer_cert,
  ##             false
  ##         }]
  ##     ]}
  ##   }].
  ##
  advancedConfiguration: |-

  ## Enable encryption to rabbitmq
  ## ref: https://www.rabbitmq.com/ssl.html
  ##
  tls:
    enabled: false
    failIfNoPeerCert: true
    sslOptionsVerify: verify_peer
    caCertificate: |-
    serverCertificate: |-
    serverKey: |-
    # existingSecret: name-of-existing-secret-to-rabbitmq

## LDAP configuration
##
ldap:
  enabled: false
  server: ""
  port: "389"
  user_dn_pattern: cn=${username},dc=example,dc=org
  tls:
    # If you enabled TLS/SSL you can set advaced options using the advancedConfiguration parameter.
    enabled: false

## Kubernetes service type
service:
  type: ClusterIP
  ## Node port
  ## ref: https://github.com/bitnami/bitnami-docker-rabbitmq#environment-variables
  ##
  # nodePort: 30672

  ## Set the ExternalIP
  ##
  # externalIPs:

  ## Set the LoadBalancerIP
  ##
  # loadBalancerIP:

  ## Node port Tls
  ##
  # nodeTlsPort: 30671

  ## Amqp port
  ## ref: https://github.com/bitnami/bitnami-docker-rabbitmq#environment-variables
  ##
  port: 5672

  ## Amqp Tls port
  ##
  tlsPort: 5671

  ## Dist port
  ## ref: https://github.com/bitnami/bitnami-docker-rabbitmq#environment-variables
  ##
  distPort: 25672

  ## RabbitMQ Manager port
  ## ref: https://github.com/bitnami/bitnami-docker-rabbitmq#environment-variables
  ##
  managerPort: 15672

  ## Service labels
  ##
  labels: {}

  ## Service annotations
  ## Example:
  ## annotations:
  ##   service.beta.kubernetes.io/aws-load-balancer-internal: 0.0.0.0/0
  ##
  annotations: {}

  ## Load Balancer sources
  ## https://kubernetes.io/docs/tasks/access-application-cluster/configure-cloud-provider-firewall/#restrict-access-for-loadbalancer-service
  ##
  # loadBalancerSourceRanges:
  # - 10.10.10.0/24

  ## Extra ports to expose
  # extraPorts:
  # - name: new_svc_name
  #   port: 1234
  #   targetPort: 1234

  ## Extra ports to be included in container spec, primarily informational
  # extraContainerPorts:
  # - name: new_svc_name
  #   port: 1234
  #   targetPort: 1234

# Additional pod labels to apply
podLabels: {}

## Pod Security Context
## ref: https://kubernetes.io/docs/tasks/configure-pod-container/security-context/
##
securityContext:
  enabled: true
  fsGroup: 1001
  runAsUser: 1001
  extra: {}

persistence:
  ## this enables PVC templates that will create one per pod
  enabled: true

  ## rabbitmq data Persistent Volume Storage Class
  ## If defined, storageClassName: <storageClass>
  ## If set to "-", storageClassName: "", which disables dynamic provisioning
  ## If undefined (the default) or set to null, no storageClassName spec is
  ##   set, choosing the default provisioner.  (gp2 on AWS, standard on
  ##   GKE, AWS & OpenStack)
  ##
  # storageClass: "-"
  ## selector can be used to match an existing PersistentVolume
  # selector:
  #   matchLabels:
  #     app: my-app
  accessMode: ReadWriteOnce

  ## Existing PersistentVolumeClaims
  ## The value is evaluated as a template
  ## So, for example, the name can depend on .Release or .Chart
  # existingClaim: ""

  # If you change this value, you might have to adjust `rabbitmq.diskFreeLimit` as well.
  size: 8Gi

  # persistence directory, maps to the rabbitmq data directory
  path: /opt/bitnami/rabbitmq/var/lib/rabbitmq

## Configure resource requests and limits
## ref: http://kubernetes.io/docs/user-guide/compute-resources/
##
resources: {}

networkPolicy:
  ## Enable creation of NetworkPolicy resources. Only Ingress traffic is filtered for now.
  ## ref: https://kubernetes.io/docs/concepts/services-networking/network-policies/
  ##
  enabled: false

  ## The Policy model to apply. When set to false, only pods with the correct
  ## client label will have network access to the ports RabbitMQ is listening
  ## on. When true, RabbitMQ will accept connections from any source
  ## (with the correct destination port).
  ##
  allowExternal: true

  ## Additional NetworkPolicy Ingress "from" rules to set. Note that all rules are OR-ed.
  ##
  # additionalRules:
  #  - matchLabels:
  #    - role: frontend
  #  - matchExpressions:
  #    - key: role
  #      operator: In
  #      values:
  #        - frontend

## Replica count, set to 1 to provide a default available cluster
replicas: 1

## Pod priority
## https://kubernetes.io/docs/concepts/configuration/pod-priority-preemption/
# priorityClassName: ""

## updateStrategy for RabbitMQ statefulset
## ref: https://kubernetes.io/docs/concepts/workloads/controllers/statefulset/#update-strategies
updateStrategy:
  type: RollingUpdate

## Affinity for pod assignment
## Ref: https://kubernetes.io/docs/concepts/configuration/assign-pod-node/#affinity-and-anti-affinity
##
affinity: {}
## Node labels for pod assignment. Evaluated as a template.
## ref: https://kubernetes.io/docs/user-guide/node-selection/
##
nodeSelector: {}
## Tolerations for pod assignment. Evaluated as a template.
## ref: https://kubernetes.io/docs/concepts/configuration/taint-and-toleration/
##
tolerations: {}
## Pod Disruption Budget configuration
## ref: https://kubernetes.io/docs/tasks/run-application/configure-pdb/
## Example:
## podDisruptionBudget:
##    maxUnavailable: 1
##    minAvailable: 1
##
podDisruptionBudget: {}
## Annotations for Rabbitmq pods
##
podAnnotations: {}

## Configure the ingress resource that allows you to access the
## Wordpress installation. Set up the URL
## ref: http://kubernetes.io/docs/user-guide/ingress/
##
ingress:
  ## Set to true to enable ingress record generation
  enabled: false

  ## The list of hostnames to be covered with this ingress record.
  ## Most likely this will be just one host, but in the event more hosts are needed, this is an array
  ## hostName: foo.bar.com
  path: /

  ## Set this to true in order to enable TLS on the ingress record
  ## A side effect of this will be that the backend wordpress service will be connected at port 443
  tls: false

  ## If TLS is set to true, you must declare what secret will store the key/certificate for TLS
  tlsSecret: myTlsSecret

  ## Ingress annotations done as key:value pairs
  ## If you're using kube-lego, you will want to add:
  ## kubernetes.io/tls-acme: true
  ##
  ## For a full list of possible ingress annotations, please see
  ## ref: https://github.com/kubernetes/ingress-nginx/blob/master/docs/user-guide/nginx-configuration/annotations.md
  ##
  ## If tls is set to true, annotation ingress.kubernetes.io/secure-backends: "true" will automatically be set
  annotations: {}
  #  kubernetes.io/ingress.class: nginx
  #  kubernetes.io/tls-acme: true

## The following settings are to configure the frequency of the lifeness and readiness probes
livenessProbe:
  enabled: true
  initialDelaySeconds: 120
  timeoutSeconds: 20
  periodSeconds: 30
  failureThreshold: 6
  successThreshold: 1
  commandOverride: []

readinessProbe:
  enabled: true
  initialDelaySeconds: 10
  timeoutSeconds: 20
  periodSeconds: 30
  failureThreshold: 3
  successThreshold: 1
  commandOverride: []

## Prometheus Metrics
##
metrics:
  enabled: false
  port: 9419
  plugins: "rabbitmq_prometheus"
  ## Prometheus pod annotations
  ## ref: https://kubernetes.io/docs/concepts/overview/working-with-objects/annotations/
  ##
  podAnnotations:
    prometheus.io/scrape: "true"
    prometheus.io/port: "{{ .Values.metrics.port }}"

  ## Prometheus Service Monitor
  ## ref: https://github.com/coreos/prometheus-operator
  ##      https://github.com/coreos/prometheus-operator/blob/master/Documentation/api.md#endpoint
  serviceMonitor:
    ## If the operator is installed in your cluster, set to true to create a Service Monitor Entry
    enabled: false
    ## Specify the namespace in which the serviceMonitor resource will be created
    # namespace: ""
    ## Specify the interval at which metrics should be scraped
    interval: 30s
    ## Specify the timeout after which the scrape is ended
    # scrapeTimeout: 30s
    ## Specify Metric Relabellings to add to the scrape endpoint
    # relabellings:
    ## Specify honorLabels parameter to add the scrape endpoint
    honorLabels: false
    ## Specify the release for ServiceMonitor. Sometimes it should be custom for prometheus operator to work
    # release: ""
    ## Used to pass Labels that are used by the Prometheus installed in your cluster to select Service Monitors to work with
    ## ref: https://github.com/coreos/prometheus-operator/blob/master/Documentation/api.md#prometheusspec
    additionalLabels: {}

  ## Custom PrometheusRule to be defined
  ## The value is evaluated as a template, so, for example, the value can depend on .Release or .Chart
  ## ref: https://github.com/coreos/prometheus-operator#customresourcedefinitions
  prometheusRule:
    enabled: false
    additionalLabels: {}
    namespace: ""
    ## List of rules, used as template by Helm.
    ## These are just examples rules inspired from https://awesome-prometheus-alerts.grep.to/rules.html
    # rules:
    #   - alert: RabbitmqDown
    #     expr: rabbitmq_up{service="{{ template "rabbitmq.fullname" . }}"} == 0
    #     for: 5m
    #     labels:
    #       severity: error
    #     annotations:
    #       summary: Rabbitmq down (instance {{ "{{ $labels.instance }}" }})
    #       description: RabbitMQ node down
    #   - alert: ClusterDown
    #     expr: |
    #       sum(rabbitmq_running{service="{{ template "rabbitmq.fullname" . }}"})
    #       < {{ .Values.replicas }}
    #     for: 5m
    #     labels:
    #       severity: error
    #     annotations:
    #       summary: Cluster down (instance {{ "{{ $labels.instance }}" }})
    #       description: |
    #           Less than {{ .Values.replicas }} nodes running in RabbitMQ cluster
    #           VALUE = {{ "{{ $value }}" }}
    #   - alert: ClusterPartition
    #     expr: rabbitmq_partitions{service="{{ template "rabbitmq.fullname" . }}"} > 0
    #     for: 5m
    #     labels:
    #       severity: error
    #     annotations:
    #       summary: Cluster partition (instance {{ "{{ $labels.instance }}" }})
    #       description: |
    #           Cluster partition
    #           VALUE = {{ "{{ $value }}" }}
    #   - alert: OutOfMemory
    #     expr: |
    #       rabbitmq_node_mem_used{service="{{ template "rabbitmq.fullname" . }}"}
    #       / rabbitmq_node_mem_limit{service="{{ template "rabbitmq.fullname" . }}"}
    #       * 100 > 90
    #     for: 5m
    #     labels:
    #       severity: warning
    #     annotations:
    #       summary: Out of memory (instance {{ "{{ $labels.instance }}" }})
    #       description: |
    #           Memory available for RabbmitMQ is low (< 10%)\n  VALUE = {{ "{{ $value }}" }}
    #           LABELS: {{ "{{ $labels }}" }}
    #   - alert: TooManyConnections
    #     expr: rabbitmq_connectionsTotal{service="{{ template "rabbitmq.fullname" . }}"} > 1000
    #     for: 5m
    #     labels:
    #       severity: warning
    #     annotations:
    #       summary: Too many connections (instance {{ "{{ $labels.instance }}" }})
    #       description: |
    #           RabbitMQ instance has too many connections (> 1000)
    #           VALUE = {{ "{{ $value }}" }}\n  LABELS: {{ "{{ $labels }}" }}
    rules: []

##
## Init containers parameters:
## volumePermissions: Change the owner of the persist volume mountpoint to RunAsUser:fsGroup
##
volumePermissions:
  enabled: false
  image:
    registry: docker.io
    repository: bitnami/minideb
    tag: buster
    pullPolicy: Always
    ## Optionally specify an array of imagePullSecrets.
    ## Secrets must be manually created in the namespace.
    ## ref: https://kubernetes.io/docs/tasks/configure-pod-container/pull-image-private-registry/
    ##
    # pullSecrets:
    #   - myRegistryKeySecretName
  resources: {}

## forceBoot: executes 'rabbitmqctl force_boot' to force boot cluster shut down unexpectedly in an
## unknown order.
## ref: https://www.rabbitmq.com/rabbitmqctl.8.html#force_boot
##
forceBoot:
  enabled: false

## Optionally specify extra secrets to be created by the chart.
## This can be useful when combined with load_definitions to automatically create the secret containing the definitions to be loaded.
## Example:
## extraSecrets:
##   load-definition:
##     load_definition.json: |
##       {
##         ...
##       }
##
extraSecrets: {}

## extraVolumes and extraVolumeMounts allows you to mount other volumes
## Examples:
## extraVolumeMounts:
##   - name: extras
##     mountPath: /usr/share/extras
##     readOnly: true
## extraVolumes:
##   - name: extras
##     emptyDir: {}
extraVolumeMounts: []
extraVolumes: []
```

#### Install Rabbit
```shell script
helm install -f "values.yaml" rabbitmq bitnami/rabbitmq
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
