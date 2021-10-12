<#-- template to create the runner script -->
<#if osName?upper_case?contains("WIN")>
@echo off
pushd %~dp0
set script_dir=%CD%
popd
cd %script_dir%
cd ..
  <#if mainModule != "">
    <#-- modular application -->
start bin\javaw${(modulePath!="")?then(" -p " + modulePath, "")}${(classPath!="")?then(" -cp " + classPath, "")} ^
  --add-exports javafx.graphics/com.sun.javafx.css=org.tentackle.fx ^
  --add-exports javafx.graphics/com.sun.javafx.scene=org.tentackle.fx ^
  --add-exports javafx.graphics/com.sun.javafx.scene.traversal=org.tentackle.fx ^
  --add-exports javafx.fxml/com.sun.javafx.fxml=org.tentackle.fx ^
  --add-exports javafx.graphics/com.sun.javafx.application=org.tentackle.fx.rdc ^
  --add-opens javafx.controls/javafx.scene.control=org.tentackle.fx ^
  -m ${mainModule}/${mainClass}
  <#else>
    <#-- classpath application -->
start bin\javaw -cp ${classPath} ${mainClass}
  </#if>
<#else>
#!/bin/sh
  <#if osName?upper_case?contains("MAC")>
abs_path() {
  echo "$(cd "$(dirname "$1")" && pwd)/$(basename "$1")"
}
cd "$(dirname "$(dirname "$(abs_path "$0")")")"
  <#else>
cd "$(dirname "$(dirname "$(readlink -f "$0")")")"
  </#if>
  <#if mainModule != "">
    <#-- modular application -->
bin/java ${(modulePath!="")?then(" -p " + modulePath, "")}${(classPath!="")?then(" -cp " + classPath, "")} \
  --add-exports javafx.graphics/com.sun.javafx.css=org.tentackle.fx \
  --add-exports javafx.graphics/com.sun.javafx.scene=org.tentackle.fx \
  --add-exports javafx.graphics/com.sun.javafx.scene.traversal=org.tentackle.fx \
  --add-exports javafx.fxml/com.sun.javafx.fxml=org.tentackle.fx \
  --add-exports javafx.graphics/com.sun.javafx.application=org.tentackle.fx.rdc \
  --add-opens javafx.controls/javafx.scene.control=org.tentackle.fx \
  -m ${mainModule}/${mainClass}
  <#else>
    <#-- classpath application -->
bin/java -cp ${classPath} ${mainClass}
  </#if>
</#if>