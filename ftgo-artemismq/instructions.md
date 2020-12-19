# Instruction
This code is based on the Helm chart here [activemq-artemis-helm][https://github.com/vromero/activemq-artemis-helm]
The overridden values are in the file `ftgo-values.yaml`

### How to run the docker image

`docker run -it --rm -p 8161:8161 -p 61616:61616 -e ARTEMIS_USERNAME=myuser -e ARTEMIS_PASSWORD=mypassword -e 'ARTEMIS_MIN_MEMORY=1512M' -e 'ARTEMIS_MAX_MEMORY=3048M' vromero/activemq-artemis`

The same values we'll use for the chart configuration.

### Run the chart
We need to map the values from the image to the ones in the chart:

| Docker image  |Helm chart  | value  |
|---|---|---|
| - | persistence.enabled  | false|
| - | replicas  | 1|
| - | artemisUser  | myuser|
| - | artemisPassword  | mypassword|
| - | resources.request.memory  | 256Mi|

The release will not run if we try to run it from the repo. 
The only option was to clone the  [GIT project][https://github.com/vromero/activemq-artemis-helm] in the folder 
`activemq-artemis/` and run the chart from there using the overridden values in the file 

`helm install artemis-mq -f ftgo-values.yaml .  `

#### Delete the release


`helm delete artemis-mq`
