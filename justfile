set shell := ["powershell", "-Command"]
[working-directory: 'src']
build:
    @echo "Building..."
    @javac *.java
    @java Main
