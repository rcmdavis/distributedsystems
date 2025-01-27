javac interfaces/*.java
javac server/*.java
javac client/*.java

jar cf distributed-systems.jar -C . interfaces -C . exceptions -C . server -C . client
