set shell := ["powershell", "-Command"]

# Build the Java project
build:
    @echo "Compiling Java source files..."
    @javac -d target/classes src/main/java/com/comp2243/bluebox/Main.java src/main/java/com/comp2243/bluebox/UserInterface.java src/main/java/com/comp2243/bluebox/ui/TextAreaOutputStream.java src/main/java/com/comp2243/bluebox/tone/*.java
    @echo "Build complete!"

# Run the application
run:
    @echo "Running BlueBox application..."
    @java -cp target/classes com.comp2243.bluebox.Main

# Clean build artifacts
clean:
    @echo "Cleaning build artifacts..."
    @if (Test-Path target) { Remove-Item -Recurse -Force target }
    @echo "Clean complete!"

# Create executable JAR file
jar:
    @echo "Creating JAR file..."
    @if (!(Test-Path target)) { New-Item -ItemType Directory -Path target }
    @jar cfe target/bluebox.jar com.comp2243.bluebox.Main -C target/classes .
    @echo "JAR file created: target/bluebox.jar"

# Run the JAR file
run-jar:
    @echo "Running BlueBox from JAR file..."
    @java -jar target/bluebox.jar

# Build and run
start: build jar run-jar

# Export to zip file
export:
    @echo "Creating ZIP file..."
    @git archive --format zip --output young-final-project.zip HEAD
