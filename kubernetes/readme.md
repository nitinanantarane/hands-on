Start cluster
<pre>
minikube start --driver='docker'
</pre>

Interact with cluster
<pre>
kubectl get po -A
</pre>

Minikube dashboard
<pre>
minikube dashboard
minikube addons enable metrics-server
</pre>

Deploy Applications
<pre>
Service
<pre>
kubectl create deployment hello-minikube --image=kicbase/echo-server:1.0
kubectl expose deployment hello-minikube --type=NodePort --port=8080
kubectl get services hello-minikube
minikube service hello-minikube
kubectl port-forward service/hello-minikube 7080:8080
</pre>

Load Balancer
<pre>
kubectl create deployment balanced --image=kicbase/echo-server:1.0
kubectl expose deployment balanced --type=LoadBalancer --port=8080
minikube tunnel
kubectl get services balanced
</pre>

Ingress
<pre>
minikube addons enable ingress
kubectl apply -f https://storage.googleapis.com/minikube-site-examples/ingress-example.yaml
kubectl get ingress
</pre>
</pre>

Manage Cluster
<pre>
minikube pause
minikube unpause
minikube stop
minikube config set memory 9001
minikube addons list
minikube start -p aged --kubernetes-version=v1.16.1
minikube delete --all
</pre>

Create Cluster
<pre>
minikube start
</pre>

Deploy sample app
<pre>
kubectl create deployment kubernetes-bootcamp --image=gcr.io/google-samples/kubernetes-bootcamp:v1
kubectl get deployments
kubectl proxy
curl http://localhost:8001/version
export POD_NAME=$(kubectl get pods -o go-template --template '{{range .items}}{{.metadata.name}}{{"\n"}}{{end}}')
echo Name of the Pod: $POD_NAME
curl http://localhost:8001/api/v1/namespaces/default/pods/$POD_NAME:8080/proxy/
</pre>

Explore App
<pre>
kubectl get pods
kubectl describe pods
kubectl proxy
export POD_NAME="$(kubectl get pods -o go-template --template '{{range .items}}{{.metadata.name}}{{"\n"}}{{end}}')"
echo Name of the Pod: $POD_NAME
curl http://localhost:8001/api/v1/namespaces/default/pods/$POD_NAME:8080/proxy/
kubectl logs "$POD_NAME"
kubectl exec "$POD_NAME" -- env
kubectl exec -ti $POD_NAME -- bash
cat server.js
curl http://localhost:8080
exit
</pre>

Expose App
<pre>
kubectl get pods
kubectl get services
kubectl expose deployment/kubernetes-bootcamp --type="NodePort" --port 8080
kubectl get services
kubectl describe services/kubernetes-bootcamp
export NODE_PORT="$(kubectl get services/kubernetes-bootcamp -o go-template='{{(index .spec.ports 0).nodePort}}')"
echo "NODE_PORT=$NODE_PORT"
curl http://"$(minikube ip):$NODE_PORT"
for Docker
minikube service kubernetes-bootcamp --url
curl 127.0.0.1:51082

kubectl describe deployment
kubectl get pods -l app=kubernetes-bootcamp
kubectl get services -l app=kubernetes-bootcamp
export POD_NAME="$(kubectl get pods -o go-template --template '{{range .items}}{{.metadata.name}}{{"\n"}}{{end}}')"
echo "Name of the Pod: $POD_NAME"
kubectl label pods "$POD_NAME" version=v1
kubectl describe pods "$POD_NAME"
kubectl get pods -l version=v1
kubectl delete service -l app=kubernetes-bootcamp
kubectl get services
curl http://"$(minikube ip):$NODE_PORT"
kubectl exec -ti $POD_NAME -- curl http://localhost:8080
</pre>