set batchPath=%~dp0
set projectCIDir=%batchPath:~0,-1%
cd %projectCIDir%

@ECHO OFF
FOR /f "tokens=*" %%i IN ('docker ps -q') DO docker stop %%i

docker-compose down
docker-compose build
docker-compose pull
docker-compose up