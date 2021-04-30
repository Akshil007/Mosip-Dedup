mkdir ThreadDukeConfigFiles
cp ./src/main/resources/duke_thread_cfg.xml ./ThreadDukeConfigFiles/duke_$1_cfg.xml
find ./ThreadDukeConfigFiles/ -type f -exec sed -i "s/thread/$1/g" {} +
