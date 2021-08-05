REM �������� ��������� ����� ���� ������ POSTGRESQL
ECHO OFF
CHCP 1251
CLS

REM ��������� ���������� ���������
SET PGBIN=d:\Programs\PostgreSQL\bin
SET PGDATABASE=PracticeDB
SET PGHOST=localhost
SET PGPORT=5432
SET PGUSER=postgres
SET PGPASSWORD=123

REM ����� ����� � ������� � ����� �� ������� ������� bat-����
%~d0
CD %~dp0

REM ������������ ����� ����� ��������� ����� � �����-������
SET DATETIME=%DATE:~6,4%-%DATE:~3,2%-%DATE:~0,2% %TIME:~0,2%-%TIME:~3,2%-%TIME:~6,2%
SET DUMPFILE=%PGDATABASE% %DATETIME%.backup
SET LOGFILE=%PGDATABASE% %DATETIME%.log
SET DUMPPATH="Backup\%DUMPFILE%"
SET LOGPATH="Backup\%LOGFILE%"

REM �������� ��������� �����
IF NOT EXIST Backup MD Backup
CALL "%PGBIN%\pg_dump.exe" --format=custom --verbose --file=%DUMPPATH% 2>%LOGPATH% --exclude-table=table4queries_*

REM ������ ���� ����������
IF NOT %ERRORLEVEL%==0 GOTO Error
GOTO Successfull

REM � ������ ������ ��������� ������������ ��������� ����� � �������� ��������������� ������ � �������
:Error
DEL %DUMPPATH%
MSG * "������ ��� �������� ��������� ����� ���� ������. �������� backup.log."
ECHO %DATETIME% ������ ��� �������� ��������� ����� ���� ������ %DUMPFILE%. �������� ����� %LOGFILE%. >> backup.log
GOTO End

REM � ������ �������� ���������� ����������� ������ �������� ������ � ������
:Successfull
ECHO %DATETIME% �������� �������� ��������� ����� %DUMPFILE% >> backup.log
	REM � ��������� ������ ����������
forfiles /p "d:\Download\practice\Practice_DB\backupping\Backup" /S /D -1 /C "cmd /c del /f /a /q @file"
GOTO End
:End