-- Adminer 4.7.2 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `club`;
CREATE TABLE `club` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `city` varchar(60) NOT NULL,
  `telephone` varchar(60) NOT NULL,
  `num_socios` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `club` (`id`, `name`, `city`, `telephone`, `num_socios`) VALUES
(1,	'even-keeled Saint Helena Pound',	'Treutelhaven',	'(478) 680-9178 x66503',	10147),
(2,	'invoice Home Gloves9999',	'Jeanchester',	'692-170-2431 x736',	74417),
(3,	'alarm local area network Benin',	'Fredyfurt',	'(225) 993-4896',	43439),
(4,	'dot-com payment Libyan Dinar',	'Dietrichberg',	'1-425-076-0199 x4929',	88349),
(5,	'back up Factors',	'West Kattie',	'599.802.3318 x23413',	55680),
(6,	'Configuration UIC-Franc',	'Antoinetteton',	'669-312-5283',	74076),
(7,	'Belize Dollar Sudanese Pound real-time',	'West Raina',	'828-690-5056 x716',	7094),
(8,	'extend Unbranded Fresh Pants Tools',	'Aureliaview',	'603.415.9285 x802',	3734),
(9,	'compressing',	'South Brandy',	'1-587-229-6408',	5168),
(10,	'Iran',	'Maximofurt',	'1-719-957-3073',	27083),
(12,	'iiiiiijjjjjj',	'oiojioijo',	'979879',	9879879);

DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(60) NOT NULL,
  `name` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `country` (`id`, `code`, `name`) VALUES
(1,	'mobile Fish 123 y',	'Home Loan Account Table Computer 3123'),
(2,	'Tracewer erd',	'Savings Account alarmrerere'),
(3,	'Tasty Metal Bacon',	'red Chips Soap'),
(4,	'Home Loan Account',	'web-readiness'),
(5,	'Namibia',	'Steel zero administration'),
(6,	'Multi-channelled Licensed',	'grey Cambridgeshire'),
(7,	'Canyon HDD',	'Table Small Frozen Sausages Planner'),
(8,	'envisioneer Music Public-key',	'infomediaries'),
(9,	'Investment Account',	'Games Regional Digitized'),
(10,	'copy convergence',	'Mayotte'),
(14,	'728',	'Julia'),
(16,	'C002',	'CAMBIO DE VIDA');

DROP TABLE IF EXISTS `DATABASECHANGELOG`;
CREATE TABLE `DATABASECHANGELOG` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `DATABASECHANGELOG` (`ID`, `AUTHOR`, `FILENAME`, `DATEEXECUTED`, `ORDEREXECUTED`, `EXECTYPE`, `MD5SUM`, `DESCRIPTION`, `COMMENTS`, `TAG`, `LIQUIBASE`, `CONTEXTS`, `LABELS`, `DEPLOYMENT_ID`) VALUES
('00000000000001',	'jhipster',	'config/liquibase/changelog/00000000000000_initial_schema.xml',	'2019-08-10 14:12:15',	1,	'EXECUTED',	'8:8e21c5375c87ff644820529f195ee600',	'createTable tableName=jhi_user; createTable tableName=jhi_authority; createTable tableName=jhi_user_authority; addPrimaryKey tableName=jhi_user_authority; addForeignKeyConstraint baseTableName=jhi_user_authority, constraintName=fk_authority_name, ...',	'',	NULL,	'3.6.3',	NULL,	NULL,	'5460734720'),
('20190810135858-1',	'jhipster',	'config/liquibase/changelog/20190810135858_added_entity_Country.xml',	'2019-08-10 14:12:15',	2,	'EXECUTED',	'8:b395d15fee758c9cb2c43bd4f80f7869',	'createTable tableName=country',	'',	NULL,	'3.6.3',	NULL,	NULL,	'5460734720'),
('20190810135858-1-relations',	'jhipster',	'config/liquibase/changelog/20190810135858_added_entity_Country.xml',	'2019-08-10 14:12:15',	3,	'EXECUTED',	'8:d41d8cd98f00b204e9800998ecf8427e',	'empty',	'',	NULL,	'3.6.3',	NULL,	NULL,	'5460734720'),
('20190810135858-1-data',	'jhipster',	'config/liquibase/changelog/20190810135858_added_entity_Country.xml',	'2019-08-10 14:12:15',	4,	'EXECUTED',	'8:3c584c2bb5a607a7205d552de4ba950f',	'loadData tableName=country',	'',	NULL,	'3.6.3',	'faker',	NULL,	'5460734720'),
('20190810135859-1',	'jhipster',	'config/liquibase/changelog/20190810135859_added_entity_Player.xml',	'2019-08-10 14:12:16',	5,	'EXECUTED',	'8:db08f31fdf0b705a196c05bf6e407608',	'createTable tableName=player',	'',	NULL,	'3.6.3',	NULL,	NULL,	'5460734720'),
('20190810135859-1-relations',	'jhipster',	'config/liquibase/changelog/20190810135859_added_entity_Player.xml',	'2019-08-10 14:12:16',	6,	'EXECUTED',	'8:d41d8cd98f00b204e9800998ecf8427e',	'empty',	'',	NULL,	'3.6.3',	NULL,	NULL,	'5460734720'),
('20190810135859-1-data',	'jhipster',	'config/liquibase/changelog/20190810135859_added_entity_Player.xml',	'2019-08-10 14:12:16',	7,	'EXECUTED',	'8:49e2338481c7c541403fd420883155ca',	'loadData tableName=player',	'',	NULL,	'3.6.3',	'faker',	NULL,	'5460734720'),
('20190810135900-1',	'jhipster',	'config/liquibase/changelog/20190810135900_added_entity_Club.xml',	'2019-08-10 14:12:16',	8,	'EXECUTED',	'8:29d1fb2b2a2a7e86fea42c8f0e1eece1',	'createTable tableName=club',	'',	NULL,	'3.6.3',	NULL,	NULL,	'5460734720'),
('20190810135900-1-relations',	'jhipster',	'config/liquibase/changelog/20190810135900_added_entity_Club.xml',	'2019-08-10 14:12:16',	9,	'EXECUTED',	'8:d41d8cd98f00b204e9800998ecf8427e',	'empty',	'',	NULL,	'3.6.3',	NULL,	NULL,	'5460734720'),
('20190810135900-1-data',	'jhipster',	'config/liquibase/changelog/20190810135900_added_entity_Club.xml',	'2019-08-10 14:12:16',	10,	'EXECUTED',	'8:aac170eb6a45ac749bbaaeba15f8c737',	'loadData tableName=club',	'',	NULL,	'3.6.3',	'faker',	NULL,	'5460734720'),
('20190810135859-2',	'jhipster',	'config/liquibase/changelog/20190810135859_added_entity_constraints_Player.xml',	'2019-08-10 14:12:16',	11,	'EXECUTED',	'8:96903e0c4a50f200db7704b869ac7269',	'addForeignKeyConstraint baseTableName=player, constraintName=fk_player_country_id, referencedTableName=country; addForeignKeyConstraint baseTableName=player, constraintName=fk_player_club_id, referencedTableName=club',	'',	NULL,	'3.6.3',	NULL,	NULL,	'5460734720');

DROP TABLE IF EXISTS `DATABASECHANGELOGLOCK`;
CREATE TABLE `DATABASECHANGELOGLOCK` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `DATABASECHANGELOGLOCK` (`ID`, `LOCKED`, `LOCKGRANTED`, `LOCKEDBY`) VALUES
(1,	CONV('0', 2, 10) + 0,	NULL,	NULL);

DROP TABLE IF EXISTS `jhi_authority`;
CREATE TABLE `jhi_authority` (
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `jhi_authority` (`name`) VALUES
('ROLE_ADMIN'),
('ROLE_USER');

DROP TABLE IF EXISTS `jhi_persistent_audit_event`;
CREATE TABLE `jhi_persistent_audit_event` (
  `event_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `principal` varchar(50) NOT NULL,
  `event_date` timestamp NULL DEFAULT NULL,
  `event_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`event_id`),
  KEY `idx_persistent_audit_event` (`principal`,`event_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `jhi_persistent_audit_event` (`event_id`, `principal`, `event_date`, `event_type`) VALUES
(1,	'admin',	'2019-08-10 22:12:59',	'AUTHENTICATION_SUCCESS'),
(2,	'admin',	'2019-08-10 22:59:50',	'AUTHENTICATION_SUCCESS'),
(3,	'admin',	'2019-08-10 23:00:09',	'AUTHENTICATION_SUCCESS'),
(4,	'admin',	'2019-08-11 00:27:36',	'AUTHENTICATION_SUCCESS'),
(5,	'admin',	'2019-08-11 04:20:57',	'AUTHENTICATION_FAILURE'),
(6,	'admin',	'2019-08-11 04:21:08',	'AUTHENTICATION_SUCCESS'),
(7,	'admin',	'2019-08-11 04:58:15',	'AUTHENTICATION_SUCCESS'),
(8,	'admin',	'2019-08-11 05:07:36',	'AUTHENTICATION_SUCCESS'),
(9,	'admin',	'2019-08-11 05:59:31',	'AUTHENTICATION_SUCCESS'),
(10,	'admin',	'2019-08-11 06:01:07',	'AUTHENTICATION_SUCCESS'),
(11,	'admin',	'2019-08-11 06:09:45',	'AUTHENTICATION_SUCCESS'),
(12,	'admin',	'2019-08-11 06:14:17',	'AUTHENTICATION_SUCCESS'),
(13,	'admin',	'2019-08-11 07:40:54',	'AUTHENTICATION_SUCCESS'),
(14,	'admin',	'2019-08-11 16:27:46',	'AUTHENTICATION_SUCCESS'),
(15,	'admin',	'2019-08-11 17:33:17',	'AUTHENTICATION_SUCCESS'),
(16,	'admin',	'2019-08-11 17:34:27',	'AUTHENTICATION_SUCCESS');

DROP TABLE IF EXISTS `jhi_persistent_audit_evt_data`;
CREATE TABLE `jhi_persistent_audit_evt_data` (
  `event_id` bigint(20) NOT NULL,
  `name` varchar(150) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`event_id`,`name`),
  KEY `idx_persistent_audit_evt_data` (`event_id`),
  CONSTRAINT `fk_evt_pers_audit_evt_data` FOREIGN KEY (`event_id`) REFERENCES `jhi_persistent_audit_event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `jhi_persistent_audit_evt_data` (`event_id`, `name`, `value`) VALUES
(5,	'message',	'Bad credentials'),
(5,	'type',	'org.springframework.security.authentication.BadCredentialsException');

DROP TABLE IF EXISTS `jhi_user`;
CREATE TABLE `jhi_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password_hash` varchar(60) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(191) DEFAULT NULL,
  `image_url` varchar(256) DEFAULT NULL,
  `activated` bit(1) NOT NULL,
  `lang_key` varchar(10) DEFAULT NULL,
  `activation_key` varchar(20) DEFAULT NULL,
  `reset_key` varchar(20) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` timestamp NULL,
  `reset_date` timestamp NULL DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_user_login` (`login`),
  UNIQUE KEY `ux_user_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `jhi_user` (`id`, `login`, `password_hash`, `first_name`, `last_name`, `email`, `image_url`, `activated`, `lang_key`, `activation_key`, `reset_key`, `created_by`, `created_date`, `reset_date`, `last_modified_by`, `last_modified_date`) VALUES
(1,	'system',	'$2a$10$mE.qmcV0mFU5NcKh73TZx.z4ueI/.bDWbj0T1BYyqP481kGGarKLG',	'System',	'System',	'system@localhost',	'',	CONV('1', 2, 10) + 0,	'es',	NULL,	NULL,	'system',	NULL,	NULL,	'system',	NULL),
(2,	'anonymoususer',	'$2a$10$j8S5d7Sr7.8VTOYNviDPOeWX8KcYILUVJBsYV83Y5NtECayypx9lO',	'Anonymous',	'User',	'anonymous@localhost',	'',	CONV('1', 2, 10) + 0,	'es',	NULL,	NULL,	'system',	NULL,	NULL,	'system',	NULL),
(3,	'admin',	'$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC',	'Administrator',	'Administrator',	'admin@localhost',	'',	CONV('1', 2, 10) + 0,	'es',	NULL,	NULL,	'system',	NULL,	NULL,	'system',	NULL),
(4,	'user',	'$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K',	'User',	'User',	'user@localhost',	'',	CONV('1', 2, 10) + 0,	'es',	NULL,	NULL,	'system',	NULL,	NULL,	'system',	NULL);

DROP TABLE IF EXISTS `jhi_user_authority`;
CREATE TABLE `jhi_user_authority` (
  `user_id` bigint(20) NOT NULL,
  `authority_name` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`,`authority_name`),
  KEY `fk_authority_name` (`authority_name`),
  CONSTRAINT `fk_authority_name` FOREIGN KEY (`authority_name`) REFERENCES `jhi_authority` (`name`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `jhi_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `jhi_user_authority` (`user_id`, `authority_name`) VALUES
(1,	'ROLE_ADMIN'),
(1,	'ROLE_USER'),
(3,	'ROLE_ADMIN'),
(3,	'ROLE_USER'),
(4,	'ROLE_USER');

DROP TABLE IF EXISTS `player`;
CREATE TABLE `player` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ci` varchar(60) NOT NULL,
  `name` varchar(60) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `position` varchar(60) NOT NULL,
  `aditional_data` varchar(255) DEFAULT NULL,
  `country_id` bigint(20) NOT NULL,
  `club_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_player_country_id` (`country_id`),
  KEY `fk_player_club_id` (`club_id`),
  CONSTRAINT `fk_player_club_id` FOREIGN KEY (`club_id`) REFERENCES `club` (`id`),
  CONSTRAINT `fk_player_country_id` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `player` (`id`, `ci`, `name`, `gender`, `position`, `aditional_data`, `country_id`, `club_id`) VALUES
(1,	'Industrial',	'connect Markets Chief',	'MALE',	'sky blue Tasty Plastic Pizza',	'compress South Georgia and the South Sandwich Islands',	6,	4),
(3,	'Highway Ergonomic8888',	'moratorium moratorium',	'MALE',	'Frozen bus',	'hard drive Robust Networked',	1,	6),
(4,	'partnerships Grocery Intelligent',	'Dynamic',	'MALE',	'Concrete Investment Account Saint Lucia',	'User-centric',	1,	6),
(5,	'Chilean Peso Unidades de fomento',	'Web virtual deposit',	'MALE',	'Ghana back-end National',	'Direct',	3,	3),
(6,	'synergies copying',	'ability Hat Iraq',	'MALE',	'User-centric Gloves',	'Mauritania',	8,	5),
(7,	'Tasty Concrete Chips Exclusive',	'Buckinghamshire capability zero tolerance',	'FEMALE',	'Berkshire Small Plastic Pants Investor',	'Canadian Dollar',	6,	5),
(8,	'Designer Persistent',	'Handmade 24/7 Re-contextualized',	'FEMALE',	'bypassing optical',	'installation',	2,	7),
(9,	'HDD',	'Algerian Dinar',	'FEMALE',	'Future-proofed deposit Sausages',	'disintermediate Cambridgeshire hacking',	7,	4),
(10,	'Concrete Global SMS',	'Profound',	'FEMALE',	'Borders content-based',	'Tasty Customer Human',	7,	2),
(11,	'3651205',	'NUMA',	'MALE',	'ARRIBA',	'NINGUNA',	14,	10),
(13,	'string',	'string',	'MALE',	'string',	'string',	1,	1),
(14,	'string',	'string',	'MALE',	'string',	'string',	2,	2);

-- 2019-08-11 14:43:29
