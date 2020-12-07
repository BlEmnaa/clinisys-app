-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 07 déc. 2020 à 04:17
-- Version du serveur :  5.7.17
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `clinisys_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `acheter`
--

CREATE TABLE `acheter` (
  `id_frs` bigint(20) NOT NULL,
  `id_produit` bigint(20) NOT NULL,
  `prix_achat` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `acheter`
--

INSERT INTO `acheter` (`id_frs`, `id_produit`, `prix_achat`) VALUES
(1, 1, '976,000'),
(2, 1, '646,000'),
(2, 3, '336,00 '),
(3, 1, '842,000'),
(3, 2, '188,000'),
(4, 2, '241,000'),
(4, 3, '328,000 ');

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `idfrs` bigint(20) NOT NULL,
  `nomfrs` varchar(255) DEFAULT NULL,
  `villfrs` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`idfrs`, `nomfrs`, `villfrs`) VALUES
(1, 'Apple', '\"'),
(2, 'Huawei ', '\"'),
(3, 'Acer', '\"'),
(4, 'LENOVO ', '\"');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id_produit` bigint(20) NOT NULL,
  `catprod` varchar(255) DEFAULT NULL,
  `desprod` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id_produit`, `catprod`, `desprod`) VALUES
(1, 'INFORMATIQUE', 'Ordinateur portable'),
(2, 'INFORMATIQUE', 'ECRANS'),
(3, 'INFORMATIQUE', 'Tablettes');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `acheter`
--
ALTER TABLE `acheter`
  ADD PRIMARY KEY (`id_frs`,`id_produit`),
  ADD KEY `FKi2lqr98nb7mexjs9q08i48apc` (`id_produit`);

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`idfrs`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id_produit`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `idfrs` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id_produit` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `acheter`
--
ALTER TABLE `acheter`
  ADD CONSTRAINT `FKi2lqr98nb7mexjs9q08i48apc` FOREIGN KEY (`id_produit`) REFERENCES `produit` (`id_produit`),
  ADD CONSTRAINT `FKjakou6exh0quex05l49d3g3pg` FOREIGN KEY (`id_frs`) REFERENCES `fournisseur` (`idfrs`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
