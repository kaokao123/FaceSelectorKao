del /f TinyCnnJni.dll *.obj *.exp *.lib com_kao_face_TinyCnnJni.h
"c:\Program Files\Java\jdk1.7.0_79\bin\javah.exe" -classpath ..\out\production\FaceSelectorKao com.kao.face.TinyCnnJni
"C:\Program Files (x86)\Microsoft Visual Studio 14.0\VC\bin\amd64\cl.exe" *.cpp /EHsc "/IC:\Program Files (x86)\Windows Kits\10\Include\10.0.10240.0\ucrt" "/IC:\Program Files (x86)\Microsoft Visual Studio 14.0\VC\include" "/IC:\Program Files\Java\jdk1.7.0_79\include" "/IC:\Program Files\Java\jdk1.7.0_79\include\win32" "/I." /FeTinyCnnJni.dll /LD /link /LIBPATH:"C:\Program Files (x86)\Microsoft Visual Studio 14.0\VC\lib\amd64" /LIBPATH:"C:\Program Files (x86)\Windows Kits\10\Lib\10.0.10240.0\um\x64" /LIBPATH:"C:\Program Files (x86)\Windows Kits\10\Lib\10.0.10240.0\ucrt\x64"
copy /y TinyCnnJni.dll C:\Windows
PAUSE
