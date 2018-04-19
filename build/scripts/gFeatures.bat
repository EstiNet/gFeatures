@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  gFeatures startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

@rem Add default JVM options here. You can also use JAVA_OPTS and G_FEATURES_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windowz variants

if not "%OS%" == "Windows_NT" goto win9xME_args
if "%@eval[2+2]" == "4" goto 4NT_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*
goto execute

:4NT_args
@rem Get arguments from the 4NT Shell from JP Software
set CMD_LINE_ARGS=%$

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\gFeatures-v3.4.3.jar;%APP_HOME%\lib\lettuce-4.2.1.Final.jar;%APP_HOME%\lib\grpc-netty-1.11.0.jar;%APP_HOME%\lib\grpc-protobuf-1.11.0.jar;%APP_HOME%\lib\grpc-stub-1.11.0.jar;%APP_HOME%\lib\paper-api-1.12.2-R0.1-SNAPSHOT.jar;%APP_HOME%\lib\spigot-api-1.12.2-R0.1-SNAPSHOT.jar;%APP_HOME%\lib\Crackshot-0.97.13.jar;%APP_HOME%\lib\rxjava-1.1.6.jar;%APP_HOME%\lib\grpc-core-1.11.0.jar;%APP_HOME%\lib\netty-codec-http2-4.1.22.Final.jar;%APP_HOME%\lib\netty-handler-proxy-4.1.22.Final.jar;%APP_HOME%\lib\protobuf-java-3.5.1.jar;%APP_HOME%\lib\protobuf-java-util-3.5.1.jar;%APP_HOME%\lib\proto-google-common-protos-1.0.0.jar;%APP_HOME%\lib\grpc-protobuf-lite-1.11.0.jar;%APP_HOME%\lib\authlib-1.5.25.jar;%APP_HOME%\lib\commons-lang-2.6.jar;%APP_HOME%\lib\json-simple-1.1.1.jar;%APP_HOME%\lib\gson-2.8.0.jar;%APP_HOME%\lib\snakeyaml-1.19.jar;%APP_HOME%\lib\bungeecord-chat-1.12-SNAPSHOT.jar;%APP_HOME%\lib\slf4j-api-1.7.25.jar;%APP_HOME%\lib\asm-all-5.0.4.jar;%APP_HOME%\lib\grpc-context-1.11.0.jar;%APP_HOME%\lib\error_prone_annotations-2.1.2.jar;%APP_HOME%\lib\opencensus-api-0.11.0.jar;%APP_HOME%\lib\opencensus-contrib-grpc-metrics-0.11.0.jar;%APP_HOME%\lib\netty-codec-http-4.1.22.Final.jar;%APP_HOME%\lib\netty-codec-socks-4.1.22.Final.jar;%APP_HOME%\lib\commons-codec-1.10.jar;%APP_HOME%\lib\commons-io-2.4.jar;%APP_HOME%\lib\log4j-api-2.8.1.jar;%APP_HOME%\lib\log4j-core-2.8.1.jar;%APP_HOME%\lib\junit-4.10.jar;%APP_HOME%\lib\hamcrest-core-1.1.jar;%APP_HOME%\lib\guava-21.0.jar;%APP_HOME%\lib\jsr305-3.0.0.jar;%APP_HOME%\lib\netty-handler-4.1.22.Final.jar;%APP_HOME%\lib\netty-transport-4.1.22.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.22.Final.jar;%APP_HOME%\lib\commons-lang3-3.5.jar;%APP_HOME%\lib\netty-codec-4.1.22.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.22.Final.jar;%APP_HOME%\lib\netty-common-4.1.22.Final.jar

@rem Execute gFeatures
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %G_FEATURES_OPTS%  -classpath "%CLASSPATH%" net.estinet.gFeatures.Listeners %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable G_FEATURES_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%G_FEATURES_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
