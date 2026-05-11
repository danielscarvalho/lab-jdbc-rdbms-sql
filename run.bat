@echo off
set "neon_postgresql_url=jdbc:postgresql://ep-silent-violet-a26temai-pooler.eu-central-1.aws.neon.tech/pucsp?user=pucsp-dba&password=xxxxxx&sslmode=require&channelBinding=require"

set "CP=.;%~dp0javalibs\*"

javac -cp "%CP%" "%~dp0NeonPostgreSQL.java"
if errorlevel 1 exit /b 1

java -cp "%CP%" NeonPostgreSQL
