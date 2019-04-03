Create a GCP Free tier account.

Create a new GCP project called springboot-on-gke.

Open GCP Cloud Shell (Boost Mode)

Clone this repository & switch to project folder.

Run following commands in sequence :

`kubectl apply -f deployment-mongo.yml`

`kubectl get pods`

`gcloud auth configure-docker`

`mvn compile jib:dockerBuild`

`docker tag springboot-istio-gke:1.0 gcr.io/$GOOGLE_CLOUD_PROJECT/springboot-istio-gke:1.0`

`docker push gcr.io/$GOOGLE_CLOUD_PROJECT/springboot-istio-gke:1.0`

`kubectl apply -f deployment.yml`

Use below export statements to get ingress host and port:

`export INGRESS_HOST=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.status.loadBalancer.ingress[0].ip}');`

`export INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].port}');`

Access at: http://<INGRESS_HOST>:<INGRESS_PORT>/cards
