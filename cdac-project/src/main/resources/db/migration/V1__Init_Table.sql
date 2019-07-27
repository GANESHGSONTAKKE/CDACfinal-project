-- --------------------------------------------------------
-- Host:                         Localhost
-- Server version:               10.1.38-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table cdac_db_project.authorities
CREATE TABLE IF NOT EXISTS `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table cdac_db_project.db_applicant
CREATE TABLE IF NOT EXISTS `db_applicant` (
  `applicant_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `experience` varchar(50) DEFAULT NULL,
  `qualifications` varchar(50) DEFAULT NULL,
  `subject_interested` varchar(50) DEFAULT NULL,
  `marital_status` varchar(50) DEFAULT NULL,
  `languages_known` varchar(50) DEFAULT NULL,
  `linkedin_link` varchar(50) DEFAULT NULL,
  `document_id` int(11) DEFAULT NULL,
  `created_timestamp` timestamp NULL DEFAULT NULL,
  `updated_timestamp` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`applicant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table cdac_db_project.db_applicant_action
CREATE TABLE IF NOT EXISTS `db_applicant_action` (
  `applicant_action_id` int(11) NOT NULL AUTO_INCREMENT,
  `applicant_id` int(11) DEFAULT NULL,
  `application_status` varchar(50) DEFAULT NULL,
  `applicant_remarks` varchar(50) DEFAULT NULL,
  `created_timestamp` timestamp NULL DEFAULT NULL,
  `updated_timestamp` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`applicant_action_id`),
  KEY `fk` (`applicant_id`),
  CONSTRAINT `fk` FOREIGN KEY (`applicant_id`) REFERENCES `db_applicant` (`applicant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table cdac_db_project.db_applicant_interview
CREATE TABLE IF NOT EXISTS `db_applicant_interview` (
  `applicant_interview_id` int(11) NOT NULL AUTO_INCREMENT,
  `applicant_id` int(11) NOT NULL DEFAULT '0',
  `applicant_stage` int(11) NOT NULL DEFAULT '0',
  `interview_schedule_date` date NOT NULL,
  `interview_schedule_time` time NOT NULL,
  `interview_schedule_notes` varchar(50) NOT NULL DEFAULT '0',
  `interview_assigned_to` varchar(50) NOT NULL DEFAULT '0',
  `interview_status` int(11) NOT NULL DEFAULT '0',
  `interview_feedback` varchar(50) NOT NULL DEFAULT '0',
  `interview_ratings` tinyint(4) NOT NULL DEFAULT '0',
  `created_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` smallint(6) NOT NULL DEFAULT '0',
  PRIMARY KEY (`applicant_interview_id`),
  KEY `FK_db_applicant_interview_db_applicant` (`applicant_id`),
  CONSTRAINT `FK_db_applicant_interview_db_applicant` FOREIGN KEY (`applicant_id`) REFERENCES `db_applicant` (`applicant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table cdac_db_project.db_assignments
CREATE TABLE IF NOT EXISTS `db_assignments` (
  `assignment_id` int(11) NOT NULL,
  `batch_to_modules_id` int(11) DEFAULT NULL,
  `module_id` int(11) DEFAULT NULL,
  `faculty_id` int(11) DEFAULT NULL,
  `document_course_id` int(11) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `created_timestamp` timestamp NULL DEFAULT NULL,
  `updated_timestamp` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`assignment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table cdac_db_project.db_batches
CREATE TABLE IF NOT EXISTS `db_batches` (
  `batch_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL DEFAULT '0',
  `batch_name` varchar(255) NOT NULL DEFAULT '0',
  `batch_start_date` date NOT NULL,
  `batch_end_date` date NOT NULL,
  `created_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`batch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table cdac_db_project.db_batch_to_modules
CREATE TABLE IF NOT EXISTS `db_batch_to_modules` (
  `batch_to_modules_id` int(11) NOT NULL AUTO_INCREMENT,
  `batch_id` int(11) NOT NULL DEFAULT '0',
  `module_id` int(11) NOT NULL DEFAULT '0',
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `remarks` varchar(255) NOT NULL DEFAULT '0',
  `faculty_id` int(11) NOT NULL DEFAULT '0',
  `created_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`batch_to_modules_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table cdac_db_project.db_courses
CREATE TABLE IF NOT EXISTS `db_courses` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(50) NOT NULL DEFAULT '0',
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table cdac_db_project.db_documents_applicants
CREATE TABLE IF NOT EXISTS `db_documents_applicants` (
  `document_id` int(11) NOT NULL AUTO_INCREMENT,
  `original_file_name` varchar(50) DEFAULT NULL,
  `file_name` varchar(50) DEFAULT NULL,
  `file_extension` varchar(50) DEFAULT NULL,
  `created_timestamp` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`document_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table cdac_db_project.db_document_courses
CREATE TABLE IF NOT EXISTS `db_document_courses` (
  `document_course_id` int(11) NOT NULL AUTO_INCREMENT,
  `original_file_name` varchar(255) NOT NULL DEFAULT '',
  `file_name` varchar(255) NOT NULL DEFAULT '',
  `file_extension` varchar(255) NOT NULL DEFAULT '',
  `add_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`document_course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table cdac_db_project.db_exam_papers
CREATE TABLE IF NOT EXISTS `db_exam_papers` (
  `exam_papers_id` int(11) NOT NULL AUTO_INCREMENT,
  `batch_to_modules_id` int(11) NOT NULL DEFAULT '0',
  `module_id` int(11) NOT NULL DEFAULT '0',
  `faculty_id` int(11) NOT NULL DEFAULT '0',
  `document_course_id` int(11) NOT NULL DEFAULT '0',
  `remarks` varchar(255) NOT NULL DEFAULT '0',
  `created_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`exam_papers_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table cdac_db_project.db_exam_results
CREATE TABLE IF NOT EXISTS `db_exam_results` (
  `exam_results_id` int(11) NOT NULL AUTO_INCREMENT,
  `batch_to_modules_id` int(11) NOT NULL,
  `module_id` int(11) NOT NULL,
  `faculty_id` int(11) NOT NULL,
  `document_course_id` int(11) NOT NULL,
  `remarks` varchar(255) NOT NULL DEFAULT '',
  `created_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`exam_results_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table cdac_db_project.db_faculty
CREATE TABLE IF NOT EXISTS `db_faculty` (
  `faculty_id` int(11) NOT NULL AUTO_INCREMENT,
  `Is_internal` tinyint(4) NOT NULL DEFAULT '0',
  `applicant_id` int(11) NOT NULL,
  `full_name` varchar(50) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  `mobile` varchar(50) NOT NULL DEFAULT '',
  `address` varchar(255) NOT NULL DEFAULT '',
  `skills` varchar(255) NOT NULL DEFAULT '',
  `dob` varchar(50) NOT NULL DEFAULT '',
  `remarks` varchar(255) NOT NULL DEFAULT '',
  `created_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`faculty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table cdac_db_project.db_faculty_workflow
CREATE TABLE IF NOT EXISTS `db_faculty_workflow` (
  `faculty_workflow_id` int(11) NOT NULL AUTO_INCREMENT,
  `batch_to_modules_id` int(11) NOT NULL,
  `mudule_id` int(11) NOT NULL,
  `faculty_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `hours` tinyint(4) NOT NULL DEFAULT '0',
  `task_description` varchar(255) NOT NULL DEFAULT '',
  `created_timpstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`faculty_workflow_id`),
  KEY `FK_db_faculty_workflow_db_modules` (`mudule_id`),
  KEY `FK_db_faculty_workflow_db_faculty` (`faculty_id`),
  KEY `FK_db_faculty_workflow_db_batch_to_modules` (`batch_to_modules_id`),
  CONSTRAINT `FK_db_faculty_workflow_db_batch_to_modules` FOREIGN KEY (`batch_to_modules_id`) REFERENCES `db_batch_to_modules` (`batch_to_modules_id`),
  CONSTRAINT `FK_db_faculty_workflow_db_faculty` FOREIGN KEY (`faculty_id`) REFERENCES `db_faculty` (`faculty_id`),
  CONSTRAINT `FK_db_faculty_workflow_db_modules` FOREIGN KEY (`mudule_id`) REFERENCES `db_modules` (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table cdac_db_project.db_login
CREATE TABLE IF NOT EXISTS `db_login` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_role` varchar(50) NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL DEFAULT '0',
  `email` varchar(50) NOT NULL DEFAULT '0',
  `password` varchar(50) NOT NULL DEFAULT '0',
  `salt` varchar(50) NOT NULL DEFAULT '0',
  `mobile` varchar(50) NOT NULL DEFAULT '0',
  `created_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table cdac_db_project.db_modules
CREATE TABLE IF NOT EXISTS `db_modules` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT,
  `module_name` varchar(50) NOT NULL DEFAULT '0',
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table cdac_db_project.schema_version
CREATE TABLE IF NOT EXISTS `schema_version` (
  `version_rank` int(11) NOT NULL,
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) NOT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`version`),
  KEY `schema_version_vr_idx` (`version_rank`),
  KEY `schema_version_ir_idx` (`installed_rank`),
  KEY `schema_version_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table cdac_db_project.users
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
