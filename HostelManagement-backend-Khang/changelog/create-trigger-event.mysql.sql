--liquibase formatted sql

--changeset lekha:1653760916797-48 endDelimiter:/
DROP TRIGGER IF EXISTS `insert_trigger_date_status_contract`
/

CREATE DEFINER=`root`@`localhost` TRIGGER `insert_trigger_date_status_contract` 
BEFORE INSERT 
ON `contracts` 
FOR EACH ROW 
BEGIN 
    IF (DATEDIFF(CURDATE(),NEW.end_date)>0) THEN 
        SET NEW.contract_status = 0; 
    END IF; 
END;
/
--rollback DROP TRIGGER IF EXISTS `insert_trigger_date_status_contract`;

--changeset lekha:1653760916797-49 endDelimiter:/
DROP TRIGGER IF EXISTS `update_trigger_date_status_contract`
/

CREATE DEFINER=`root`@`localhost` TRIGGER `update_trigger_date_status_contract` 
BEFORE UPDATE 
ON `contracts` 
FOR EACH ROW 
BEGIN 
    IF (DATEDIFF(CURDATE(),NEW.end_date)>0) THEN 
        SET NEW.contract_status = 0; 
    END IF; 
END;
/
--rollback DROP TRIGGER IF EXISTS `update_trigger_date_status_contract`;

--changeset lekha:1653760916797-50
DROP EVENT IF EXISTS `event_date_status_contract`; 
CREATE DEFINER=`root`@`localhost` EVENT `event_date_status_contract` 
ON SCHEDULE EVERY 1 DAY 
STARTS '2022-05-25 17:34:42' 
ON COMPLETION PRESERVE ENABLE 
DO 
    UPDATE contract
    SET contract.contract_status = 0 
    WHERE DATEDIFF(CURDATE(),contract.end_date)>0
--rollback DROP EVENT IF EXISTS `event_date_status_contract`; 