SELECT e.name
FROM Employee e
JOIN Employee m
ON m.managerId = e.id
GROUP BY e.id, e.name
HAVING COUNT(m.id) >= 5;