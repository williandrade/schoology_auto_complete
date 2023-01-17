DROP TABLE IF EXISTS `schoology`.`student`;

CREATE TABLE `schoology`.`student` (
  `id` int(11) NOT NULL,
  `full_name` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `schoology`.`student` (`id`, `full_name`) VALUES
(1, 'William'),
(2, 'Wilson'),
(3, 'Jhon'),
(4, 'Ana');

ALTER TABLE `schoology`.`student`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `schoology`.`student` ADD FULLTEXT KEY `full_name` (`full_name`);

ALTER TABLE `schoology`.`student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;