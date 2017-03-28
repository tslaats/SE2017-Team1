
::
::  @project >> 
::  @authors >> Philip Falck
::  @contact >> phfa@di.ku.dk
::  @version >> 
::  @updated >> 18/02-2017
::  @licence >> MIT
::

@echo off

if exist "bin" (
    
    rd "bin" /s /q
)

mkdir "bin"

javac -d bin/ src/*.java

if %errorlevel% equ 0 (
    
    cd bin
    
    echo Main-Class: Main >manifest.txt
    
    jar cfm start.jar manifest.txt *.class
    
    del /s /q /f *.class > nul
    
    del manifest.txt > nul
    
    java -jar start.jar
)

if %errorlevel% neq 0 (
    
    rd "bin" /s /q
)

pause
