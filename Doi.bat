#!/bin/sh
 
git filter-branch --env-filter '

OLD_EMAIL="seshan10@me.com"
CORRECT_NAME="aguy867"
CORRECT_EMAIL="aguy867@gmail.com"

if [ "$GIT_COMMITTER_EMAIL" = "$seshan10@me.com" ]
then
    export GIT_COMMITTER_NAME="$aguy867"
    export GIT_COMMITTER_EMAIL="$aguy867@gmail.com"
fi
if [ "$GIT_AUTHOR_EMAIL" = "$seshan10@me.com" ]
then
    export GIT_AUTHOR_NAME="$aguy867"
    export GIT_AUTHOR_EMAIL="$aguy867@gmail.com"
fi
' --tag-name-filter cat -- --branches --tags