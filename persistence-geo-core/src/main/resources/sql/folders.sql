INSERT INTO folder(
            id, enabled, canal, instrumento_planificacion, updatedate, createdate, 
            name_folder, user_id)
    VALUES (1, true, true, false, null, null, 
            "${default_admin_user} folder", 1);
INSERT INTO folder(
            id, enabled, canal, instrumento_planificacion, updatedate, createdate, 
            name_folder, auth_id)
    VALUES (1, true, true, false, null, null, 
            "admin folder", 1);