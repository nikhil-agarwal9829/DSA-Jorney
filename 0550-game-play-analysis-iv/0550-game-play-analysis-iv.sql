SELECT ROUND(
    COUNT(DISTINCT a.player_id) /
    (SELECT COUNT(DISTINCT player_id) FROM Activity),
    2
) AS fraction
FROM Activity a
WHERE EXISTS (
    SELECT 1
    FROM Activity b
    WHERE a.player_id = b.player_id
      AND a.event_date = DATE_ADD(b.event_date, INTERVAL 1 DAY)
      AND b.event_date = (
          SELECT MIN(event_date)
          FROM Activity
          WHERE player_id = b.player_id
      )
);