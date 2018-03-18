#!/bin/bash
# replace objects with the file with the output of the script1....groovy
cat objects| grep "\- true" | perl -npe "s/\.//g" | grep -v "Restriction" | perl -npe "s/^(.*?)\((.*?)$/\1/g"
