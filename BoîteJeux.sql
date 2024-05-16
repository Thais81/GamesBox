-- phpMyAdmin SQL Dump
-- version 5.2.1deb1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : jeu. 16 mai 2024 à 06:48
-- Version du serveur : 10.11.6-MariaDB-0+deb12u1
-- Version de PHP : 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `aeroport`
--
CREATE DATABASE IF NOT EXISTS `aeroport` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `aeroport`;

-- --------------------------------------------------------

--
-- Structure de la table `avion`
--

CREATE TABLE `avion` (
  `id_avion` int(11) NOT NULL,
  `type` varchar(15) DEFAULT NULL,
  `capacite` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
-- Erreur de lecture des données pour la table aeroport.avion : #1064 - Erreur de syntaxe près de &#039;FROM `aeroport`.`avion`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `log`
--

CREATE TABLE `log` (
  `dateModif` date DEFAULT NULL,
  `typeModif` varchar(255) DEFAULT NULL,
  `valeurModif` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table aeroport.log : #1064 - Erreur de syntaxe près de &#039;FROM `aeroport`.`log`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `pilote`
--

CREATE TABLE `pilote` (
  `id_pilote` int(11) NOT NULL,
  `nom` varchar(15) DEFAULT NULL,
  `prenom` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
-- Erreur de lecture des données pour la table aeroport.pilote : #1064 - Erreur de syntaxe près de &#039;FROM `aeroport`.`pilote`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `vol`
--

CREATE TABLE `vol` (
  `id_vol` int(11) NOT NULL,
  `depart` varchar(9) DEFAULT NULL,
  `arrivee` varchar(13) DEFAULT NULL,
  `id_avion` int(11) NOT NULL,
  `id_pilote` int(11) NOT NULL,
  `jdep` date DEFAULT NULL,
  `hdep` time DEFAULT NULL,
  `jarr` date DEFAULT NULL,
  `harr` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
-- Erreur de lecture des données pour la table aeroport.vol : #1064 - Erreur de syntaxe près de &#039;FROM `aeroport`.`vol`&#039; à la ligne 1

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `avion`
--
ALTER TABLE `avion`
  ADD PRIMARY KEY (`id_avion`);

--
-- Index pour la table `pilote`
--
ALTER TABLE `pilote`
  ADD PRIMARY KEY (`id_pilote`);

--
-- Index pour la table `vol`
--
ALTER TABLE `vol`
  ADD PRIMARY KEY (`id_vol`),
  ADD KEY `id_avion` (`id_avion`),
  ADD KEY `id_pilote` (`id_pilote`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `avion`
--
ALTER TABLE `avion`
  MODIFY `id_avion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `pilote`
--
ALTER TABLE `pilote`
  MODIFY `id_pilote` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `vol`
--
ALTER TABLE `vol`
  MODIFY `id_vol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `vol`
--
ALTER TABLE `vol`
  ADD CONSTRAINT `vol_ibfk_1` FOREIGN KEY (`id_pilote`) REFERENCES `pilote` (`id_pilote`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `vol_ibfk_2` FOREIGN KEY (`id_avion`) REFERENCES `avion` (`id_avion`) ON DELETE CASCADE ON UPDATE CASCADE;
--
-- Base de données : `Blog`
--
CREATE DATABASE IF NOT EXISTS `Blog` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `Blog`;

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `id_article` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `created` date NOT NULL,
  `author` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table Blog.article : #1064 - Erreur de syntaxe près de &#039;FROM `Blog`.`article`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `person`
--

CREATE TABLE `person` (
  `id_person` int(11) NOT NULL,
  `login` varchar(12) NOT NULL,
  `pwd` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table Blog.person : #1064 - Erreur de syntaxe près de &#039;FROM `Blog`.`person`&#039; à la ligne 1

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id_article`),
  ADD KEY `author` (`author`);

--
-- Index pour la table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id_person`),
  ADD UNIQUE KEY `login` (`login`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `id_article` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `person`
--
ALTER TABLE `person`
  MODIFY `id_person` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `article_ibfk_1` FOREIGN KEY (`author`) REFERENCES `person` (`id_person`) ON DELETE CASCADE ON UPDATE CASCADE;
--
-- Base de données : `BlogJPA`
--
CREATE DATABASE IF NOT EXISTS `BlogJPA` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `BlogJPA`;

-- --------------------------------------------------------

--
-- Structure de la table `Article`
--

CREATE TABLE `Article` (
  `id_article` int(11) NOT NULL,
  `titre` varchar(100) NOT NULL,
  `contenu` text NOT NULL,
  `id_blog` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table BlogJPA.Article : #1064 - Erreur de syntaxe près de &#039;FROM `BlogJPA`.`Article`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `Blog`
--

CREATE TABLE `Blog` (
  `id_blog` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table BlogJPA.Blog : #1064 - Erreur de syntaxe près de &#039;FROM `BlogJPA`.`Blog`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `Commentaire`
--

CREATE TABLE `Commentaire` (
  `id_commentaire` int(11) NOT NULL,
  `contenu` text NOT NULL,
  `id_article` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table BlogJPA.Commentaire : #1064 - Erreur de syntaxe près de &#039;FROM `BlogJPA`.`Commentaire`&#039; à la ligne 1

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Article`
--
ALTER TABLE `Article`
  ADD PRIMARY KEY (`id_article`),
  ADD UNIQUE KEY `id_blog` (`id_blog`);

--
-- Index pour la table `Blog`
--
ALTER TABLE `Blog`
  ADD PRIMARY KEY (`id_blog`);

--
-- Index pour la table `Commentaire`
--
ALTER TABLE `Commentaire`
  ADD PRIMARY KEY (`id_commentaire`),
  ADD UNIQUE KEY `id_article` (`id_article`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Article`
--
ALTER TABLE `Article`
  MODIFY `id_article` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Blog`
--
ALTER TABLE `Blog`
  MODIFY `id_blog` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Commentaire`
--
ALTER TABLE `Commentaire`
  MODIFY `id_commentaire` int(11) NOT NULL AUTO_INCREMENT;
--
-- Base de données : `BoîteJeux`
--
CREATE DATABASE IF NOT EXISTS `BoîteJeux` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `BoîteJeux`;

-- --------------------------------------------------------

--
-- Structure de la table `Game`
--

CREATE TABLE `Game` (
  `id_game` int(11) NOT NULL,
  `gameName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table BoîteJeux.Game : #1064 - Erreur de syntaxe près de &#039;FROM `BoîteJeux`.`Game`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `HangmanWord`
--

CREATE TABLE `HangmanWord` (
  `id_HangmanWord` int(11) NOT NULL,
  `guessed_word` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table BoîteJeux.HangmanWord : #1064 - Erreur de syntaxe près de &#039;FROM `BoîteJeux`.`HangmanWord`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `Play`
--

CREATE TABLE `Play` (
  `id_user` int(11) NOT NULL,
  `id_game` int(11) NOT NULL,
  `nb_win` int(11) NOT NULL,
  `nb_playedgames` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table BoîteJeux.Play : #1064 - Erreur de syntaxe près de &#039;FROM `BoîteJeux`.`Play`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `User`
--

CREATE TABLE `User` (
  `id_user` int(11) NOT NULL,
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `mail` varchar(155) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table BoîteJeux.User : #1064 - Erreur de syntaxe près de &#039;FROM `BoîteJeux`.`User`&#039; à la ligne 1

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Game`
--
ALTER TABLE `Game`
  ADD PRIMARY KEY (`id_game`),
  ADD UNIQUE KEY `gameName` (`gameName`);

--
-- Index pour la table `HangmanWord`
--
ALTER TABLE `HangmanWord`
  ADD PRIMARY KEY (`id_HangmanWord`);

--
-- Index pour la table `Play`
--
ALTER TABLE `Play`
  ADD PRIMARY KEY (`id_user`,`id_game`),
  ADD UNIQUE KEY `id_user` (`id_user`),
  ADD KEY `Id_Game` (`id_game`);

--
-- Index pour la table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `login` (`login`),
  ADD UNIQUE KEY `mail` (`mail`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `User`
--
ALTER TABLE `User`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Play`
--
ALTER TABLE `Play`
  ADD CONSTRAINT `Play_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `User` (`id_user`),
  ADD CONSTRAINT `Play_ibfk_2` FOREIGN KEY (`id_game`) REFERENCES `Game` (`id_game`);
--
-- Base de données : `BoîteJeuxTest`
--
CREATE DATABASE IF NOT EXISTS `BoîteJeuxTest` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `BoîteJeuxTest`;
--
-- Base de données : `db_example`
--
CREATE DATABASE IF NOT EXISTS `db_example` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `db_example`;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table db_example.user : #1064 - Erreur de syntaxe près de &#039;FROM `db_example`.`user`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `user_seq`
--

CREATE TABLE `user_seq` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) UNSIGNED NOT NULL,
  `cycle_option` tinyint(1) UNSIGNED NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB;
-- Erreur de lecture des données pour la table db_example.user_seq : #1064 - Erreur de syntaxe près de &#039;FROM `db_example`.`user_seq`&#039; à la ligne 1

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);
--
-- Base de données : `demo_jpa`
--
CREATE DATABASE IF NOT EXISTS `demo_jpa` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `demo_jpa`;

-- --------------------------------------------------------

--
-- Structure de la table `Adresse`
--

CREATE TABLE `Adresse` (
  `id_adresse` bigint(20) NOT NULL,
  `ville` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table demo_jpa.Adresse : #1064 - Erreur de syntaxe près de &#039;FROM `demo_jpa`.`Adresse`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `Adresse_SEQ`
--

CREATE TABLE `Adresse_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) UNSIGNED NOT NULL,
  `cycle_option` tinyint(1) UNSIGNED NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB;
-- Erreur de lecture des données pour la table demo_jpa.Adresse_SEQ : #1064 - Erreur de syntaxe près de &#039;FROM `demo_jpa`.`Adresse_SEQ`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `association_priorities`
--

CREATE TABLE `association_priorities` (
  `id_personne` int(11) NOT NULL,
  `id_adresse` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table demo_jpa.association_priorities : #1064 - Erreur de syntaxe près de &#039;FROM `demo_jpa`.`association_priorities`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `Personne`
--

CREATE TABLE `Personne` (
  `id_personne` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table demo_jpa.Personne : #1064 - Erreur de syntaxe près de &#039;FROM `demo_jpa`.`Personne`&#039; à la ligne 1

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Adresse`
--
ALTER TABLE `Adresse`
  ADD PRIMARY KEY (`id_adresse`);

--
-- Index pour la table `association_priorities`
--
ALTER TABLE `association_priorities`
  ADD UNIQUE KEY `UK_esaj1y8m2je4t44a4brstr563` (`id_adresse`),
  ADD KEY `FKic628o3i1bqu6sbw1922ccpxb` (`id_personne`);

--
-- Index pour la table `Personne`
--
ALTER TABLE `Personne`
  ADD PRIMARY KEY (`id_personne`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Adresse`
--
ALTER TABLE `Adresse`
  MODIFY `id_adresse` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=154;

--
-- AUTO_INCREMENT pour la table `Personne`
--
ALTER TABLE `Personne`
  MODIFY `id_personne` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `association_priorities`
--
ALTER TABLE `association_priorities`
  ADD CONSTRAINT `FK5djddxeoyq422p6md7dtwl048` FOREIGN KEY (`id_adresse`) REFERENCES `Adresse` (`id_adresse`),
  ADD CONSTRAINT `FKic628o3i1bqu6sbw1922ccpxb` FOREIGN KEY (`id_personne`) REFERENCES `Personne` (`id_personne`);
--
-- Base de données : `example`
--
CREATE DATABASE IF NOT EXISTS `example` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `example`;

-- --------------------------------------------------------

--
-- Structure de la table `person`
--

CREATE TABLE `person` (
  `id_person` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `id_role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table example.person : #1064 - Erreur de syntaxe près de &#039;FROM `example`.`person`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `id_role` int(11) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table example.role : #1064 - Erreur de syntaxe près de &#039;FROM `example`.`role`&#039; à la ligne 1

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id_person`),
  ADD KEY `id_role` (`id_role`),
  ADD KEY `id_role_2` (`id_role`),
  ADD KEY `login` (`login`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id_role`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `person`
--
ALTER TABLE `person`
  MODIFY `id_person` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `id_role` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Base de données : `logInfoUpdate`
--
CREATE DATABASE IF NOT EXISTS `logInfoUpdate` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `logInfoUpdate`;

-- --------------------------------------------------------

--
-- Structure de la table `info`
--

CREATE TABLE `info` (
  `id_info` int(11) NOT NULL,
  `valeur` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table logInfoUpdate.info : #1064 - Erreur de syntaxe près de &#039;FROM `logInfoUpdate`.`info`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `log`
--

CREATE TABLE `log` (
  `id_log` int(11) NOT NULL,
  `dateMAJ` timestamp NOT NULL DEFAULT current_timestamp(),
  `oldValue` varchar(255) DEFAULT NULL,
  `newValue` varchar(255) DEFAULT NULL,
  `userName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table logInfoUpdate.log : #1064 - Erreur de syntaxe près de &#039;FROM `logInfoUpdate`.`log`&#039; à la ligne 1

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `info`
--
ALTER TABLE `info`
  ADD PRIMARY KEY (`id_info`);

--
-- Index pour la table `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`id_log`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `info`
--
ALTER TABLE `info`
  MODIFY `id_info` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `log`
--
ALTER TABLE `log`
  MODIFY `id_log` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Base de données : `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- Structure de la table `pma__bookmark`
--

CREATE TABLE `pma__bookmark` (
  `id` int(10) UNSIGNED NOT NULL,
  `dbase` varchar(255) NOT NULL DEFAULT '',
  `user` varchar(255) NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '',
  `query` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='Bookmarks';
-- Erreur de lecture des données pour la table phpmyadmin.pma__bookmark : #1064 - Erreur de syntaxe près de &#039;FROM `phpmyadmin`.`pma__bookmark`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `pma__central_columns`
--

CREATE TABLE `pma__central_columns` (
  `db_name` varchar(64) NOT NULL,
  `col_name` varchar(64) NOT NULL,
  `col_type` varchar(64) NOT NULL,
  `col_length` text DEFAULT NULL,
  `col_collation` varchar(64) NOT NULL,
  `col_isNull` tinyint(1) NOT NULL,
  `col_extra` varchar(255) DEFAULT '',
  `col_default` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='Central list of columns';
-- Erreur de lecture des données pour la table phpmyadmin.pma__central_columns : #1064 - Erreur de syntaxe près de &#039;FROM `phpmyadmin`.`pma__central_columns`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `pma__column_info`
--

CREATE TABLE `pma__column_info` (
  `id` int(5) UNSIGNED NOT NULL,
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `table_name` varchar(64) NOT NULL DEFAULT '',
  `column_name` varchar(64) NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '',
  `transformation` varchar(255) NOT NULL DEFAULT '',
  `transformation_options` varchar(255) NOT NULL DEFAULT '',
  `input_transformation` varchar(255) NOT NULL DEFAULT '',
  `input_transformation_options` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='Column information for phpMyAdmin';
-- Erreur de lecture des données pour la table phpmyadmin.pma__column_info : #1064 - Erreur de syntaxe près de &#039;FROM `phpmyadmin`.`pma__column_info`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `pma__designer_settings`
--

CREATE TABLE `pma__designer_settings` (
  `username` varchar(64) NOT NULL,
  `settings_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='Settings related to Designer';
-- Erreur de lecture des données pour la table phpmyadmin.pma__designer_settings : #1064 - Erreur de syntaxe près de &#039;FROM `phpmyadmin`.`pma__designer_settings`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `pma__export_templates`
--

CREATE TABLE `pma__export_templates` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) NOT NULL,
  `export_type` varchar(10) NOT NULL,
  `template_name` varchar(64) NOT NULL,
  `template_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='Saved export templates';
-- Erreur de lecture des données pour la table phpmyadmin.pma__export_templates : #1064 - Erreur de syntaxe près de &#039;FROM `phpmyadmin`.`pma__export_templates`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `pma__favorite`
--

CREATE TABLE `pma__favorite` (
  `username` varchar(64) NOT NULL,
  `tables` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='Favorite tables';
-- Erreur de lecture des données pour la table phpmyadmin.pma__favorite : #1064 - Erreur de syntaxe près de &#039;FROM `phpmyadmin`.`pma__favorite`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `pma__history`
--

CREATE TABLE `pma__history` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(64) NOT NULL DEFAULT '',
  `db` varchar(64) NOT NULL DEFAULT '',
  `table` varchar(64) NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp(),
  `sqlquery` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='SQL history for phpMyAdmin';
-- Erreur de lecture des données pour la table phpmyadmin.pma__history : #1064 - Erreur de syntaxe près de &#039;FROM `phpmyadmin`.`pma__history`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `pma__navigationhiding`
--

CREATE TABLE `pma__navigationhiding` (
  `username` varchar(64) NOT NULL,
  `item_name` varchar(64) NOT NULL,
  `item_type` varchar(64) NOT NULL,
  `db_name` varchar(64) NOT NULL,
  `table_name` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='Hidden items of navigation tree';
-- Erreur de lecture des données pour la table phpmyadmin.pma__navigationhiding : #1064 - Erreur de syntaxe près de &#039;FROM `phpmyadmin`.`pma__navigationhiding`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `pma__pdf_pages`
--

CREATE TABLE `pma__pdf_pages` (
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `page_nr` int(10) UNSIGNED NOT NULL,
  `page_descr` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='PDF relation pages for phpMyAdmin';
-- Erreur de lecture des données pour la table phpmyadmin.pma__pdf_pages : #1064 - Erreur de syntaxe près de &#039;FROM `phpmyadmin`.`pma__pdf_pages`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `pma__recent`
--

CREATE TABLE `pma__recent` (
  `username` varchar(64) NOT NULL,
  `tables` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='Recently accessed tables';
-- Erreur de lecture des données pour la table phpmyadmin.pma__recent : #1064 - Erreur de syntaxe près de &#039;FROM `phpmyadmin`.`pma__recent`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `pma__relation`
--

CREATE TABLE `pma__relation` (
  `master_db` varchar(64) NOT NULL DEFAULT '',
  `master_table` varchar(64) NOT NULL DEFAULT '',
  `master_field` varchar(64) NOT NULL DEFAULT '',
  `foreign_db` varchar(64) NOT NULL DEFAULT '',
  `foreign_table` varchar(64) NOT NULL DEFAULT '',
  `foreign_field` varchar(64) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='Relation table';
-- Erreur de lecture des données pour la table phpmyadmin.pma__relation : #1064 - Erreur de syntaxe près de &#039;FROM `phpmyadmin`.`pma__relation`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `pma__savedsearches`
--

CREATE TABLE `pma__savedsearches` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) NOT NULL DEFAULT '',
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `search_name` varchar(64) NOT NULL DEFAULT '',
  `search_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='Saved searches';
-- Erreur de lecture des données pour la table phpmyadmin.pma__savedsearches : #1064 - Erreur de syntaxe près de &#039;FROM `phpmyadmin`.`pma__savedsearches`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `pma__table_coords`
--

CREATE TABLE `pma__table_coords` (
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `table_name` varchar(64) NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT 0,
  `x` float UNSIGNED NOT NULL DEFAULT 0,
  `y` float UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='Table coordinates for phpMyAdmin PDF output';
-- Erreur de lecture des données pour la table phpmyadmin.pma__table_coords : #1064 - Erreur de syntaxe près de &#039;FROM `phpmyadmin`.`pma__table_coords`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `pma__table_info`
--

CREATE TABLE `pma__table_info` (
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `table_name` varchar(64) NOT NULL DEFAULT '',
  `display_field` varchar(64) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='Table information for phpMyAdmin';
-- Erreur de lecture des données pour la table phpmyadmin.pma__table_info : #1064 - Erreur de syntaxe près de &#039;FROM `phpmyadmin`.`pma__table_info`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `pma__table_uiprefs`
--

CREATE TABLE `pma__table_uiprefs` (
  `username` varchar(64) NOT NULL,
  `db_name` varchar(64) NOT NULL,
  `table_name` varchar(64) NOT NULL,
  `prefs` text NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='Tables'' UI preferences';
-- Erreur de lecture des données pour la table phpmyadmin.pma__table_uiprefs : #1064 - Erreur de syntaxe près de &#039;FROM `phpmyadmin`.`pma__table_uiprefs`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `pma__tracking`
--

CREATE TABLE `pma__tracking` (
  `db_name` varchar(64) NOT NULL,
  `table_name` varchar(64) NOT NULL,
  `version` int(10) UNSIGNED NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text NOT NULL,
  `schema_sql` text DEFAULT NULL,
  `data_sql` longtext DEFAULT NULL,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') DEFAULT NULL,
  `tracking_active` int(1) UNSIGNED NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='Database changes tracking for phpMyAdmin';
-- Erreur de lecture des données pour la table phpmyadmin.pma__tracking : #1064 - Erreur de syntaxe près de &#039;FROM `phpmyadmin`.`pma__tracking`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `pma__userconfig`
--

CREATE TABLE `pma__userconfig` (
  `username` varchar(64) NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `config_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='User preferences storage for phpMyAdmin';
-- Erreur de lecture des données pour la table phpmyadmin.pma__userconfig : #1064 - Erreur de syntaxe près de &#039;FROM `phpmyadmin`.`pma__userconfig`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `pma__usergroups`
--

CREATE TABLE `pma__usergroups` (
  `usergroup` varchar(64) NOT NULL,
  `tab` varchar(64) NOT NULL,
  `allowed` enum('Y','N') NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='User groups with configured menu items';
-- Erreur de lecture des données pour la table phpmyadmin.pma__usergroups : #1064 - Erreur de syntaxe près de &#039;FROM `phpmyadmin`.`pma__usergroups`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `pma__users`
--

CREATE TABLE `pma__users` (
  `username` varchar(64) NOT NULL,
  `usergroup` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='Users and their assignments to user groups';
-- Erreur de lecture des données pour la table phpmyadmin.pma__users : #1064 - Erreur de syntaxe près de &#039;FROM `phpmyadmin`.`pma__users`&#039; à la ligne 1

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `pma__central_columns`
--
ALTER TABLE `pma__central_columns`
  ADD PRIMARY KEY (`db_name`,`col_name`);

--
-- Index pour la table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`);

--
-- Index pour la table `pma__designer_settings`
--
ALTER TABLE `pma__designer_settings`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_user_type_template` (`username`,`export_type`,`template_name`);

--
-- Index pour la table `pma__favorite`
--
ALTER TABLE `pma__favorite`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `pma__history`
--
ALTER TABLE `pma__history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`,`db`,`table`,`timevalue`);

--
-- Index pour la table `pma__navigationhiding`
--
ALTER TABLE `pma__navigationhiding`
  ADD PRIMARY KEY (`username`,`item_name`,`item_type`,`db_name`,`table_name`);

--
-- Index pour la table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  ADD PRIMARY KEY (`page_nr`),
  ADD KEY `db_name` (`db_name`);

--
-- Index pour la table `pma__recent`
--
ALTER TABLE `pma__recent`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `pma__relation`
--
ALTER TABLE `pma__relation`
  ADD PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  ADD KEY `foreign_field` (`foreign_db`,`foreign_table`);

--
-- Index pour la table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_savedsearches_username_dbname` (`username`,`db_name`,`search_name`);

--
-- Index pour la table `pma__table_coords`
--
ALTER TABLE `pma__table_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`);

--
-- Index pour la table `pma__table_info`
--
ALTER TABLE `pma__table_info`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- Index pour la table `pma__table_uiprefs`
--
ALTER TABLE `pma__table_uiprefs`
  ADD PRIMARY KEY (`username`,`db_name`,`table_name`);

--
-- Index pour la table `pma__tracking`
--
ALTER TABLE `pma__tracking`
  ADD PRIMARY KEY (`db_name`,`table_name`,`version`);

--
-- Index pour la table `pma__userconfig`
--
ALTER TABLE `pma__userconfig`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `pma__usergroups`
--
ALTER TABLE `pma__usergroups`
  ADD PRIMARY KEY (`usergroup`,`tab`,`allowed`);

--
-- Index pour la table `pma__users`
--
ALTER TABLE `pma__users`
  ADD PRIMARY KEY (`username`,`usergroup`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `pma__history`
--
ALTER TABLE `pma__history`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  MODIFY `page_nr` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- Base de données : `projetNouvelles`
--
CREATE DATABASE IF NOT EXISTS `projetNouvelles` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `projetNouvelles`;

-- --------------------------------------------------------

--
-- Structure de la table `Commentaire`
--

CREATE TABLE `Commentaire` (
  `id_Commentaire` int(11) NOT NULL,
  `contenu` text NOT NULL,
  `date_publication` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `etat` varchar(50) NOT NULL DEFAULT 'neutre',
  `id_Nouvelle` int(11) NOT NULL,
  `id_Utilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table projetNouvelles.Commentaire : #1064 - Erreur de syntaxe près de &#039;FROM `projetNouvelles`.`Commentaire`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `Nouvelle`
--

CREATE TABLE `Nouvelle` (
  `id_Nouvelle` int(11) NOT NULL,
  `titre` varchar(50) NOT NULL,
  `descriptif` varchar(200) NOT NULL,
  `contenu` text NOT NULL,
  `date_publication` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `id_Utilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table projetNouvelles.Nouvelle : #1064 - Erreur de syntaxe près de &#039;FROM `projetNouvelles`.`Nouvelle`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `Utilisateur`
--

CREATE TABLE `Utilisateur` (
  `id_Utilisateur` int(11) NOT NULL,
  `pseudo` varchar(50) NOT NULL,
  `estActif` tinyint(1) NOT NULL DEFAULT 1,
  `mot_de_passe` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table projetNouvelles.Utilisateur : #1064 - Erreur de syntaxe près de &#039;FROM `projetNouvelles`.`Utilisateur`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `Vote`
--

CREATE TABLE `Vote` (
  `id_Utilisateur` int(11) NOT NULL,
  `id_Nouvelle` int(11) NOT NULL,
  `qualite` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table projetNouvelles.Vote : #1064 - Erreur de syntaxe près de &#039;FROM `projetNouvelles`.`Vote`&#039; à la ligne 1

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Commentaire`
--
ALTER TABLE `Commentaire`
  ADD PRIMARY KEY (`id_Commentaire`),
  ADD KEY `id_Nouvelle` (`id_Nouvelle`),
  ADD KEY `Commentaire_ibfk_1` (`id_Utilisateur`);

--
-- Index pour la table `Nouvelle`
--
ALTER TABLE `Nouvelle`
  ADD PRIMARY KEY (`id_Nouvelle`),
  ADD KEY `Nouvelle_ibfk_1` (`id_Utilisateur`);

--
-- Index pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD PRIMARY KEY (`id_Utilisateur`),
  ADD UNIQUE KEY `pseudo` (`pseudo`) USING BTREE;

--
-- Index pour la table `Vote`
--
ALTER TABLE `Vote`
  ADD PRIMARY KEY (`id_Utilisateur`,`id_Nouvelle`),
  ADD KEY `Vote_ibfk_2` (`id_Nouvelle`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Commentaire`
--
ALTER TABLE `Commentaire`
  MODIFY `id_Commentaire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=82;

--
-- AUTO_INCREMENT pour la table `Nouvelle`
--
ALTER TABLE `Nouvelle`
  MODIFY `id_Nouvelle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  MODIFY `id_Utilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Commentaire`
--
ALTER TABLE `Commentaire`
  ADD CONSTRAINT `Commentaire_ibfk_1` FOREIGN KEY (`id_Utilisateur`) REFERENCES `Utilisateur` (`id_Utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Commentaire_ibfk_2` FOREIGN KEY (`id_Nouvelle`) REFERENCES `Nouvelle` (`id_Nouvelle`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `Nouvelle`
--
ALTER TABLE `Nouvelle`
  ADD CONSTRAINT `Nouvelle_ibfk_1` FOREIGN KEY (`id_Utilisateur`) REFERENCES `Utilisateur` (`id_Utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `Vote`
--
ALTER TABLE `Vote`
  ADD CONSTRAINT `Vote_ibfk_1` FOREIGN KEY (`id_Utilisateur`) REFERENCES `Utilisateur` (`id_Utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Vote_ibfk_2` FOREIGN KEY (`id_Nouvelle`) REFERENCES `Nouvelle` (`id_Nouvelle`) ON DELETE CASCADE ON UPDATE CASCADE;
--
-- Base de données : `ski`
--
CREATE DATABASE IF NOT EXISTS `ski` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `ski`;

-- --------------------------------------------------------

--
-- Structure de la table `banque`
--

CREATE TABLE `banque` (
  `id_banque` int(11) NOT NULL,
  `nom_banque` varchar(100) NOT NULL,
  `adresse_banque` varchar(100) NOT NULL,
  `cp_banque` char(5) NOT NULL,
  `commune_banque` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table ski.banque : #1064 - Erreur de syntaxe près de &#039;FROM `ski`.`banque`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id_client` int(11) NOT NULL,
  `nom_client` varchar(100) NOT NULL,
  `adr_client` varchar(100) NOT NULL,
  `cp_client` char(5) NOT NULL,
  `commune_client` varchar(100) DEFAULT NULL,
  `id_banque` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table ski.client : #1064 - Erreur de syntaxe près de &#039;FROM `ski`.`client`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `id_facture` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `numero` varchar(15) NOT NULL,
  `date_edition` date NOT NULL,
  `date_paiement` date DEFAULT NULL,
  `num_cheque` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table ski.facture : #1064 - Erreur de syntaxe près de &#039;FROM `ski`.`facture`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id_produit` int(11) NOT NULL,
  `ref_produit` varchar(50) NOT NULL,
  `designation` varchar(2000) NOT NULL,
  `prix` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table ski.produit : #1064 - Erreur de syntaxe près de &#039;FROM `ski`.`produit`&#039; à la ligne 1

-- --------------------------------------------------------

--
-- Structure de la table `prod_by_fact`
--

CREATE TABLE `prod_by_fact` (
  `id_facture` int(11) NOT NULL,
  `id_produit` int(11) NOT NULL,
  `quantite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- Erreur de lecture des données pour la table ski.prod_by_fact : #1064 - Erreur de syntaxe près de &#039;FROM `ski`.`prod_by_fact`&#039; à la ligne 1

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `banque`
--
ALTER TABLE `banque`
  ADD PRIMARY KEY (`id_banque`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`),
  ADD KEY `fk_client_banque` (`id_banque`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`id_facture`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id_produit`),
  ADD UNIQUE KEY `ref_produit` (`ref_produit`);

--
-- Index pour la table `prod_by_fact`
--
ALTER TABLE `prod_by_fact`
  ADD KEY `fk_id_facture` (`id_facture`),
  ADD KEY `fk_id_produit` (`id_produit`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `banque`
--
ALTER TABLE `banque`
  MODIFY `id_banque` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `facture`
--
ALTER TABLE `facture`
  MODIFY `id_facture` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id_produit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `fk_client_banque` FOREIGN KEY (`id_banque`) REFERENCES `banque` (`id_banque`);

--
-- Contraintes pour la table `prod_by_fact`
--
ALTER TABLE `prod_by_fact`
  ADD CONSTRAINT `fk_id_facture` FOREIGN KEY (`id_facture`) REFERENCES `facture` (`id_facture`),
  ADD CONSTRAINT `fk_id_produit` FOREIGN KEY (`id_produit`) REFERENCES `produit` (`id_produit`);
--
-- Base de données : `stag2`
--
CREATE DATABASE IF NOT EXISTS `stag2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `stag2`;
--
-- Base de données : `wordpress`
--
CREATE DATABASE IF NOT EXISTS `wordpress` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `wordpress`;
--
-- Base de données : `wp-stag`
--
CREATE DATABASE IF NOT EXISTS `wp-stag` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `wp-stag`;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
