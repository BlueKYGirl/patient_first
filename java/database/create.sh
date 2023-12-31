#!/bin/bash
export PGPASSWORD='postgres1'
BASEDIR=$(dirname $0)
DATABASE=final_capstone
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres $DATABASE &&
psql -U postgres -d $DATABASE -f "$BASEDIR/schema.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/data.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/maintables.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/foreign_key.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/metadata.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/spoof_data.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/user.sql"
