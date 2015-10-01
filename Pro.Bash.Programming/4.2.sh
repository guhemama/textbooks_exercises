#!/usr/bin/bash

# User must enter a valid path
while true; do
  read file_path
  test -e "$file_path" && break
done
