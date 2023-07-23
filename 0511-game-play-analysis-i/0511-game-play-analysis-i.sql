##select player_id, event_date as first_login from Activity group by player_id order by event_date desc limit 1; 


Select player_id, min(event_date) as first_login from activity group by player_id 