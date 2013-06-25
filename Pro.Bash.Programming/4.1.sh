#!/usr/bin/bash

# User must enter a number between 20 and 30
while true; do
  read number
  if [[ "$number" =~ ^[0-9]+$ ]] && [ "$number" -le 30 ] && [ "$number" -ge 20 ]; then
    break
  fi
done

printf "The number is %d\n" $number
