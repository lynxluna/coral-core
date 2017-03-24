#!/usr/bin/env bash

if [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
  openssl aes-256-cbc -K $encrypted_0b85eb490145_key -iv $encrypted_0b85eb490145_iv -in codesigning.asc.enc -out codesigning.asc -d
  gpg2 --import codesigning.asc
fi