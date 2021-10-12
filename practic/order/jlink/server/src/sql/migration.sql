
-- create the migration table

CREATE TABLE migration (
    version VARCHAR(32),
    since TIMESTAMP,
    comment VARCHAR(512)
);
COMMENT ON TABLE migration IS 'migration history';
COMMENT ON COLUMN migration.version IS 'deployment date';
COMMENT ON COLUMN migration.since IS 'deployment date';
COMMENT ON COLUMN migration.comment IS 'additional comments';

INSERT INTO migration (version, since, comment) VALUES ('1.0-SNAPSHOT', '2021-10-11 14:30:48', 'Project Start');



