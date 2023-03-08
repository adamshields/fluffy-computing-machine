# CREATE TABLE design (
#   id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
#   design_version VARCHAR(255) NOT NULL,
#   design_name VARCHAR(255) NOT NULL,
#   is_editable BOOLEAN NOT NULL
# );
#
# CREATE TABLE users (
#   id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
#   email VARCHAR(255) NOT NULL,
#   first_name VARCHAR(255) NOT NULL,
#   last_name VARCHAR(255) NOT NULL,
#   employee_id VARCHAR(255) NOT NULL
# );
#
# CREATE TABLE design_approvals (
#   id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
#   fully_approved BOOLEAN NOT NULL,
#   level_1_approval VARCHAR(300) NOT NULL,
#   level_2_approval VARCHAR(300) NOT NULL,
#   level_3_approval VARCHAR(300) NOT NULL,
#   design_id BIGINT NOT NULL,
#   FOREIGN KEY (design_id) REFERENCES design(id)
# );
