INSTALL_DIR = /c/Windows
JAVA_DIR = /c/Program\ Files/Java/jdk1.7.0_79/include

CC = g++
CFLAGS = -std=c++11 -m64 -D__STAND_ALONE -D__int64=int64_t -I$(JAVA_DIR) -I$(JAVA_DIR)/win32 -I. -Wall -D_JNI_IMPLEMENTATION_
LDFLAGS = -Wl,--kill-at -Wl,--subsystem,windows
HEADERS = $(wildcard *.h)
SOURCES = $(wildcard *.cpp)
OBJS = $(patsubst %.cpp,%.o,$(SOURCES))
OUT_DLL = TinyCnnJni.dll
OUT_EXE = test.exe
INSTALL_DLL = $(INSTALL_DIR)/$(OUT_DLL)

.PHONY: all
all: $(OUT_DLL)
	@echo "Done."

exe: $(OUT_EXE)
	@echo "Create executable file done."

$(OUT_DLL): $(OBJS)
	$(CC) $(CFLAGS) -o $@ -s -shared $(OBJS) $(LDFLAGS)

$(OUT_EXE): $(OBJS)
	$(CC) $(CFLAGS) -o $@ $(OBJS)

.cpp.o: $(HEADERS)
	$(CC) $(CFLAGS) -c $<

.PHONY: install
install: $(OUT_DLL)
	cp $< $(INSTALL_DLL)
	@echo "Install Done."

.PHONY: clean
clean:
	rm -f $(OBJS) $(OUT_DLL) $(INSTALL_DLL) $(OUT_EXE)
