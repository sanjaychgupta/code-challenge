#!/bin/sh

git filter-branch --env-filter '

OLD_EMAIL="sanjay.gupta@rakuten.com"
CORRECT_NAME="Sanjay Gupta"
CORRECT_EMAIL="sanjay.ch.gupta@gmail.com"

if [ "$GIT_COMMITTER_EMAIL" = "$OLD_EMAIL" ]
then
export GIT_COMMITTER_NAME="$CORRECT_NAME"
export GIT_COMMITTER_EMAIL="$CORRECT_EMAIL"
fi
if [ "$GIT_AUTHOR_EMAIL" = "$OLD_EMAIL" ]
then
export GIT_AUTHOR_NAME="$CORRECT_NAME"
export GIT_AUTHOR_EMAIL="$CORRECT_EMAIL"
fi
' --tag-name-filter cat -- --branches --tags


# Changing Your Committer Name & Email Globally
# git config --global user.name "Sanjay Gupta"
# git config --global user.email "sanjay.ch.gupta@gmail.com"

# Changing Your Committer Name & Email per Repository
# git config user.name "Sanjay Gupta"
# git config user.email "sanjay.ch.gupta@gmail.com"