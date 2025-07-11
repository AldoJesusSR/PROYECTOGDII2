﻿USE [NutricionBD]
GO
/****** Object:  Table [dbo].[Alimentos]    Script Date: 1/06/2025 02:14:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Alimentos](
	[alimento] [varchar](100) NOT NULL,
	[cantidad] [varchar](50) NOT NULL,
	[fecha] [date] NOT NULL,
	[calorias] [int] NOT NULL,
	[nombreRegistro] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[nombreRegistro] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[auditoria_alimentos]    Script Date: 1/06/2025 02:14:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[auditoria_alimentos](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[operacion] [varchar](10) NULL,
	[alimento] [varchar](100) NULL,
	[cantidad] [varchar](50) NULL,
	[fecha] [date] NULL,
	[calorias] [int] NULL,
	[nombreRegistro] [varchar](100) NULL,
	[fechaEvento] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[auditoria_diagnostico]    Script Date: 1/06/2025 02:14:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[auditoria_diagnostico](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[operacion] [varchar](10) NULL,
	[nombreRegistro] [varchar](100) NULL,
	[dieta] [varchar](max) NULL,
	[estadoCalorico] [varchar](50) NULL,
	[equilibrioMacro] [varchar](100) NULL,
	[recomendaciones] [varchar](max) NULL,
	[fechaOriginal] [datetime] NULL,
	[fechaEvento] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[auditoria_historial]    Script Date: 1/06/2025 02:14:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[auditoria_historial](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[operacion] [varchar](10) NULL,
	[nombreRegistro] [varchar](100) NULL,
	[fechaRegistro] [date] NULL,
	[caloriasTotales] [int] NULL,
	[alerta] [varchar](255) NULL,
	[recomendacion] [varchar](max) NULL,
	[fechaEvento] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[diagnostico_nutricional]    Script Date: 1/06/2025 02:14:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[diagnostico_nutricional](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombreRegistro] [varchar](100) NULL,
	[dieta] [varchar](max) NULL,
	[estadoCalorico] [varchar](50) NULL,
	[equilibrioMacro] [varchar](100) NULL,
	[recomendaciones] [varchar](max) NULL,
	[fecha] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[historial_comidas]    Script Date: 1/06/2025 02:14:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[historial_comidas](
	[nombreRegistro] [varchar](100) NOT NULL,
	[fechaRegistro] [date] NOT NULL,
	[caloriasTotales] [int] NOT NULL,
	[alerta] [varchar](255) NULL,
	[recomendacion] [varchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[nombreRegistro] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[auditoria_alimentos] ADD  DEFAULT (getdate()) FOR [fechaEvento]
GO
ALTER TABLE [dbo].[auditoria_diagnostico] ADD  DEFAULT (getdate()) FOR [fechaEvento]
GO
ALTER TABLE [dbo].[auditoria_historial] ADD  DEFAULT (getdate()) FOR [fechaEvento]
GO
ALTER TABLE [dbo].[diagnostico_nutricional] ADD  DEFAULT (getdate()) FOR [fecha]
GO
/****** Object:  StoredProcedure [dbo].[sp_ContarAlertasPorTipo]    Script Date: 1/06/2025 02:14:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_ContarAlertasPorTipo]
AS
BEGIN
    DECLARE @alerta VARCHAR(255), @cantidad INT;

    DECLARE curAlertas CURSOR FOR
    SELECT alerta, COUNT(*) AS cantidad FROM historial_comidas GROUP BY alerta;

    OPEN curAlertas;
    FETCH NEXT FROM curAlertas INTO @alerta, @cantidad;

    PRINT 'Cantidad de registros por tipo de alerta:';
    WHILE @@FETCH_STATUS = 0
    BEGIN
        PRINT CONCAT('- Alerta: ', @alerta, ' | Total registros: ', @cantidad);
        FETCH NEXT FROM curAlertas INTO @alerta, @cantidad;
    END;

    CLOSE curAlertas;
    DEALLOCATE curAlertas;
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_ContarAlimentosPorFecha]    Script Date: 1/06/2025 02:14:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_ContarAlimentosPorFecha]
AS
BEGIN
    DECLARE @fecha DATE, @cantidad INT;

    DECLARE curFechas CURSOR FOR
    SELECT fecha, COUNT(*) AS cantidad FROM Alimentos GROUP BY fecha ORDER BY fecha;

    OPEN curFechas;
    FETCH NEXT FROM curFechas INTO @fecha, @cantidad;

    PRINT 'Cantidad de alimentos registrados por fecha:';
    WHILE @@FETCH_STATUS = 0
    BEGIN
        PRINT CONCAT('- Fecha: ', CONVERT(VARCHAR, @fecha, 103), ' | Total alimentos: ', @cantidad);
        FETCH NEXT FROM curFechas INTO @fecha, @cantidad;
    END;

    CLOSE curFechas;
    DEALLOCATE curFechas;
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_ContarDiagnosticosPorEstado]    Script Date: 1/06/2025 02:14:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_ContarDiagnosticosPorEstado]
AS
BEGIN
    DECLARE @estadoCalorico VARCHAR(50), @cantidad INT;

    DECLARE curEstados CURSOR FOR
    SELECT estadoCalorico, COUNT(*) AS cantidad FROM diagnostico_nutricional GROUP BY estadoCalorico;

    OPEN curEstados;
    FETCH NEXT FROM curEstados INTO @estadoCalorico, @cantidad;

    PRINT 'Cantidad de diagnósticos por estado calórico:';
    WHILE @@FETCH_STATUS = 0
    BEGIN
        PRINT CONCAT('- Estado: ', @estadoCalorico, ' | Total diagnósticos: ', @cantidad);
        FETCH NEXT FROM curEstados INTO @estadoCalorico, @cantidad;
    END;

    CLOSE curEstados;
    DEALLOCATE curEstados;
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_guardarDiagnostico]    Script Date: 1/06/2025 02:14:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_guardarDiagnostico]
    @nombreRegistro VARCHAR(100),
    @dieta TEXT,
    @estadoCalorico VARCHAR(50),
    @equilibrioMacro VARCHAR(100),
    @recomendaciones TEXT
AS
BEGIN
    INSERT INTO diagnostico_nutricional (nombreRegistro, dieta, estadoCalorico, equilibrioMacro, recomendaciones)
    VALUES (@nombreRegistro, @dieta, @estadoCalorico, @equilibrioMacro, @recomendaciones);
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_guardarResumenNutricional]    Script Date: 1/06/2025 02:14:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_guardarResumenNutricional]
    @nombreRegistro VARCHAR(100),
    @fechaRegistro DATE,
    @caloriasTotales INT,
    @alerta VARCHAR(255),
    @recomendacion VARCHAR(MAX)
AS
BEGIN
    INSERT INTO historial_comidas (nombreRegistro, fechaRegistro, caloriasTotales, alerta, recomendacion)
    VALUES (@nombreRegistro, @fechaRegistro, @caloriasTotales, @alerta, @recomendacion);
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_ListarRegistrosAlimentarios]    Script Date: 1/06/2025 02:14:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_ListarRegistrosAlimentarios]
AS
BEGIN
    DECLARE @alimento VARCHAR(100), @cantidad VARCHAR(50), @fecha DATE, @calorias INT, @nombreRegistro VARCHAR(100);

    DECLARE curAlimentos CURSOR FOR
    SELECT alimento, cantidad, fecha, calorias, nombreRegistro FROM Alimentos;

    OPEN curAlimentos;
    FETCH NEXT FROM curAlimentos INTO @alimento, @cantidad, @fecha, @calorias, @nombreRegistro;

    PRINT 'Listado de alimentos registrados:';
    WHILE @@FETCH_STATUS = 0
    BEGIN
        PRINT CONCAT('- Registro: ', @nombreRegistro, ' | Alimento: ', @alimento, ' | Cantidad: ', @cantidad, 
                     ' | Calorías: ', @calorias, ' | Fecha: ', CONVERT(VARCHAR, @fecha, 103));
        FETCH NEXT FROM curAlimentos INTO @alimento, @cantidad, @fecha, @calorias, @nombreRegistro;
    END;

    CLOSE curAlimentos;
    DEALLOCATE curAlimentos;
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_obtenerResumenNutricional]    Script Date: 1/06/2025 02:14:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_obtenerResumenNutricional]
    @fechaInicio DATE,
    @fechaFin DATE
AS
BEGIN
    SELECT 
        SUM(calorias) AS totalCalorias,  -- <== CAMBIO AQUÍ
        MIN(fecha) AS fechaInicio,
        MAX(fecha) AS fechaFin
    FROM Alimentos
    WHERE fecha BETWEEN @fechaInicio AND @fechaFin;
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_registrarAlimento]    Script Date: 1/06/2025 02:14:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_registrarAlimento]
    @alimento VARCHAR(100),
    @cantidad VARCHAR(50),
    @fecha DATE,
    @calorias INT,
    @nombreRegistro VARCHAR(100),
    @mensaje VARCHAR(100) OUTPUT
AS
BEGIN
    BEGIN TRY
        INSERT INTO Alimentos (alimento, cantidad, fecha, calorias, nombreRegistro)
        VALUES (@alimento, @cantidad, @fecha, @calorias, @nombreRegistro);

        SET @mensaje = 'Registro exitoso';
    END TRY
    BEGIN CATCH
        -- Validar si fue por clave duplicada
        IF ERROR_NUMBER() = 2627
            SET @mensaje = 'Error: nombreRegistro ya existe.';
        ELSE
            SET @mensaje = ERROR_MESSAGE();
    END CATCH
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_VerAlimentos]    Script Date: 1/06/2025 02:14:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_VerAlimentos]
AS
BEGIN
    DECLARE @alimento VARCHAR(100), @cantidad VARCHAR(50), @fecha DATE, @calorias INT, @nombreRegistro VARCHAR(100);

    DECLARE curAlimentos CURSOR FOR
    SELECT alimento, cantidad, fecha, calorias, nombreRegistro FROM Alimentos;

    OPEN curAlimentos;
    FETCH NEXT FROM curAlimentos INTO @alimento, @cantidad, @fecha, @calorias, @nombreRegistro;

    PRINT '📋 Lista de alimentos registrados:';
    WHILE @@FETCH_STATUS = 0
    BEGIN
        PRINT CONCAT('- ', @nombreRegistro, ': ', @alimento, ' (', @cantidad, ') | ', @calorias, ' cal | Fecha: ', CONVERT(VARCHAR, @fecha, 103));
        FETCH NEXT FROM curAlimentos INTO @alimento, @cantidad, @fecha, @calorias, @nombreRegistro;
    END;

    CLOSE curAlimentos;
    DEALLOCATE curAlimentos;
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_VerHistorialComidas]    Script Date: 1/06/2025 02:14:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_VerHistorialComidas]
AS
BEGIN
    DECLARE @nombreRegistro VARCHAR(100), @fecha DATE, @caloriasTotales INT, @alerta VARCHAR(255), @recomendacion VARCHAR(MAX);

    DECLARE curHistorial CURSOR FOR
    SELECT nombreRegistro, fechaRegistro, caloriasTotales, alerta, recomendacion FROM historial_comidas;

    OPEN curHistorial;
    FETCH NEXT FROM curHistorial INTO @nombreRegistro, @fecha, @caloriasTotales, @alerta, @recomendacion;

    PRINT '📋 Historial nutricional:';
    WHILE @@FETCH_STATUS = 0
    BEGIN
        PRINT CONCAT('- ', @nombreRegistro, ' | Fecha: ', CONVERT(VARCHAR, @fecha, 103), ' | Calorías: ', @caloriasTotales, ' | Alerta: ', @alerta);
        PRINT CONCAT('  Recomendación: ', @recomendacion);
        FETCH NEXT FROM curHistorial INTO @nombreRegistro, @fecha, @caloriasTotales, @alerta, @recomendacion;
    END;

    CLOSE curHistorial;
    DEALLOCATE curHistorial;
END;
GO
------------------------------------------------------------------------------------------------------------
CREATE TABLE auditoria_alimentos (
    id INT IDENTITY(1,1) PRIMARY KEY,
    operacion VARCHAR(10),
    alimento VARCHAR(100),
    cantidad VARCHAR(50),
    fecha DATE,
    calorias INT,
    nombreRegistro VARCHAR(100),
    fechaEvento DATETIME DEFAULT GETDATE()
);

CREATE TRIGGER tr_insert_alimentos
ON Alimentos
AFTER INSERT
AS
BEGIN
    INSERT INTO auditoria_alimentos (operacion, alimento, cantidad, fecha, calorias, nombreRegistro)
    SELECT 'INSERT', alimento, cantidad, fecha, calorias, nombreRegistro
    FROM inserted;
END;

CREATE TRIGGER tr_delete_alimentos
ON Alimentos
AFTER DELETE
AS
BEGIN
    INSERT INTO auditoria_alimentos (operacion, alimento, cantidad, fecha, calorias, nombreRegistro)
    SELECT 'DELETE', alimento, cantidad, fecha, calorias, nombreRegistro
    FROM deleted;
END;

CREATE TRIGGER tr_update_alimentos
ON Alimentos
AFTER UPDATE
AS
BEGIN
    INSERT INTO auditoria_alimentos (operacion, alimento, cantidad, fecha, calorias, nombreRegistro)
    SELECT 'UPDATE', alimento, cantidad, fecha, calorias, nombreRegistro
    FROM inserted;
END;

SELECT * FROM auditoria_alimentos;

-------------------------------------------------------------------------------------

CREATE TABLE auditoria_historial (
    id INT IDENTITY(1,1) PRIMARY KEY,
    operacion VARCHAR(10),
    nombreRegistro VARCHAR(100),
    fechaRegistro DATE,
    caloriasTotales INT,
    alerta VARCHAR(255),
    recomendacion VARCHAR(MAX),
    fechaEvento DATETIME DEFAULT GETDATE()
);

CREATE TRIGGER tr_insert_historial
ON historial_comidas
AFTER INSERT
AS
BEGIN
    INSERT INTO auditoria_historial (operacion, nombreRegistro, fechaRegistro, caloriasTotales, alerta, recomendacion)
    SELECT 'INSERT', nombreRegistro, fechaRegistro, caloriasTotales, alerta, recomendacion
    FROM inserted;
END;

CREATE TRIGGER tr_delete_historial
ON historial_comidas
AFTER DELETE
AS
BEGIN
    INSERT INTO auditoria_historial (operacion, nombreRegistro, fechaRegistro, caloriasTotales, alerta, recomendacion)
    SELECT 'DELETE', nombreRegistro, fechaRegistro, caloriasTotales, alerta, recomendacion
    FROM deleted;
END;

CREATE TRIGGER tr_update_historial
ON historial_comidas
AFTER UPDATE
AS
BEGIN
    INSERT INTO auditoria_historial (operacion, nombreRegistro, fechaRegistro, caloriasTotales, alerta, recomendacion)
    SELECT 'UPDATE', nombreRegistro, fechaRegistro, caloriasTotales, alerta, recomendacion
    FROM inserted;
END;

SELECT * FROM auditoria_historial;

-------------------------------------------------------------------------------------------

CREATE TABLE auditoria_diagnostico (
    id INT IDENTITY(1,1) PRIMARY KEY,
    operacion VARCHAR(10),
    nombreRegistro VARCHAR(100),
    dieta TEXT,
    estadoCalorico VARCHAR(50),
    equilibrioMacro VARCHAR(100),
    recomendaciones TEXT,
    fechaOriginal DATETIME,
    fechaEvento DATETIME DEFAULT GETDATE()
);

CREATE TRIGGER tr_insert_diagnostico
ON diagnostico_nutricional
AFTER INSERT
AS
BEGIN
    INSERT INTO auditoria_diagnostico (operacion, nombreRegistro, dieta, estadoCalorico, equilibrioMacro, recomendaciones, fechaOriginal)
    SELECT 'INSERT', nombreRegistro, dieta, estadoCalorico, equilibrioMacro, recomendaciones, fecha
    FROM inserted;
END;

CREATE TRIGGER tr_delete_diagnostico
ON diagnostico_nutricional
AFTER DELETE
AS
BEGIN
    INSERT INTO auditoria_diagnostico (operacion, nombreRegistro, dieta, estadoCalorico, equilibrioMacro, recomendaciones, fechaOriginal)
    SELECT 'DELETE', nombreRegistro, dieta, estadoCalorico, equilibrioMacro, recomendaciones, fecha
    FROM deleted;
END;

CREATE TRIGGER tr_update_diagnostico
ON diagnostico_nutricional
AFTER UPDATE
AS
BEGIN
    INSERT INTO auditoria_diagnostico (operacion, nombreRegistro, dieta, estadoCalorico, equilibrioMacro, recomendaciones, fechaOriginal)
    SELECT 'UPDATE', nombreRegistro, dieta, estadoCalorico, equilibrioMacro, recomendaciones, fecha
    FROM inserted;
END;

SELECT * FROM auditoria_diagnostico;

----------------------------------------------------

SELECT * FROM auditoria_alimentos;
SELECT * FROM auditoria_historial;

SELECT * FROM auditoria_diagnostico;
DELETE FROM auditoria_diagnostico;

INSERT INTO diagnostico_nutricional (nombreRegistro, dieta, estadoCalorico, equilibrioMacro, recomendaciones)
VALUES 
('Registro51', 'Dieta balanceada', 'Déficit calórico', 'Equilibrado', 'Consumir más proteínas.');

UPDATE diagnostico_nutricional
SET estadoCalorico = 'Exceso calórico', recomendaciones = 'Reducir grasas y azúcares.'
WHERE nombreRegistro = 'Registro51';

DELETE FROM diagnostico_nutricional
WHERE nombreRegistro = 'Registro51';
