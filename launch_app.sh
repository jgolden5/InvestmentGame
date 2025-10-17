#!/bin/bash
system_type="$(uname -a)"

if [[ $system_type =~ "MINGW64" ]]; then
  start src/frontEnd/start.html
elif [[ $system_type =~ "Darwin" ]]; then
  open src/frontEnd/start.html
else
  echo "System type \"$system_type\" not recognized, no vimrc file transfer was automated"
fi
