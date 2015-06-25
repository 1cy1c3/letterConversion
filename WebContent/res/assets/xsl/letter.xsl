<?xml version="1.0"?>
<xs:stylesheet version="1.0"
	xmlns:xs="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">

	<xs:attribute-set name="block-style">
		<xs:attribute name="font-size">  11pt</xs:attribute>
		<xs:attribute name="line-height">15pt</xs:attribute>
		<xs:attribute name="start-indent">1mm</xs:attribute>
		<xs:attribute name="end-indent">  1mm</xs:attribute>
	</xs:attribute-set>

	<xs:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="DIN-A4"
					page-height="29.7cm" page-width="21cm" margin-top="1cm"
					margin-bottom="1cm" margin-left="1cm" margin-right="1cm">
					<fo:region-body margin-top="1cm" margin-bottom="1cm"
						margin-left="1cm" margin-right="1cm" />
					<fo:region-before region-name="header" extent="1cm" />
					<fo:region-after region-name="footer" extent="1cm" />
					<fo:region-start region-name="left" extent="1cm" />
					<fo:region-end region-name="right" extent="1cm" />
				</fo:simple-page-master>
			</fo:layout-master-set>

			<fo:page-sequence master-reference="DIN-A4">
				<fo:static-content flow-name="header">
					<fo:block font-size="12pt" text-align="center">
						<!-- Geschaeftsbrief -->
					</fo:block>
				</fo:static-content>
				<fo:static-content flow-name="footer">
					<fo:block text-align="center">
						Seite
						<fo:page-number />
						von
						<fo:page-number-citation ref-id="LastPage" />
					</fo:block>
				</fo:static-content>
				<fo:flow flow-name="xsl-region-body">
					<xs:apply-templates />
					<fo:block id="LastPage" />
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xs:template>

	<!-- Adressen-Root-Element-Template -->
	<xs:template match="letters">
		<xs:apply-templates select="letter" />
	</xs:template>

	<xs:template match="letter">

		<fo:block margin-bottom="30px">
			<fo:table>
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell column-number="1">
							<fo:block>
								<fo:block xs:use-attribute-sets="block-style"
									linefeed-treatment="preserve">
									<xs:value-of select="sender/surname" />
									<xs:text> </xs:text>
									<xs:value-of select="sender/name" />
								</fo:block>
								<fo:block xs:use-attribute-sets="block-style"
									linefeed-treatment="preserve">
									<xs:value-of select="sender/street" />
									<xs:text> </xs:text>
									<xs:value-of select="sender/nr" />
								</fo:block>
								<fo:block xs:use-attribute-sets="block-style"
									linefeed-treatment="preserve">
									<xs:value-of select="sender/plz" />
									<xs:text> </xs:text>
									<xs:value-of select="sender/place" />
								</fo:block>
								<fo:block xs:use-attribute-sets="block-style"
									linefeed-treatment="preserve">
									<xs:text>Telefon: </xs:text>
									<xs:value-of select="sender/phone" />
								</fo:block>
								<fo:block xs:use-attribute-sets="block-style"
									linefeed-treatment="preserve">
									<xs:text>E-Mail: </xs:text>
									<xs:value-of select="sender/email" />
								</fo:block>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell column-number="2">
							<fo:block text-align="right">
								<fo:block xs:use-attribute-sets="block-style"
									linefeed-treatment="preserve">
									<xs:value-of select="date" />
								</fo:block>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
		</fo:block>



		<fo:block xs:use-attribute-sets="block-style"
			linefeed-treatment="preserve">
			<xs:value-of select="recipient/surname" />
			<xs:text> </xs:text>
			<xs:value-of select="recipient/name" />
		</fo:block>
		<fo:block xs:use-attribute-sets="block-style"
			linefeed-treatment="preserve">
			<xs:value-of select="recipient/street" />
			<xs:text> </xs:text>
			<xs:value-of select="recipient/nr" />
		</fo:block>
		<fo:block xs:use-attribute-sets="block-style" margin-bottom="50px"
			linefeed-treatment="preserve">
			<xs:value-of select="recipient/plz" />
			<xs:text> </xs:text>
			<xs:value-of select="recipient/place" />
		</fo:block>

		<xs:if test="reference!=''">
			<fo:block xs:use-attribute-sets="block-style" font-weight="bold"
				linefeed-treatment="preserve">
				<xs:value-of select="reference" />
			</fo:block>
		</xs:if>

		<fo:block xs:use-attribute-sets="block-style" font-weight="bold"
			margin-bottom="30px" linefeed-treatment="preserve">
			<xs:value-of select="regard" />
		</fo:block>

		<fo:block xs:use-attribute-sets="block-style" margin-bottom="0px"
			linefeed-treatment="preserve">
			<xs:value-of select="salutation" />
		</fo:block>

		<fo:block xs:use-attribute-sets="block-style" margin-bottom="25px"
			linefeed-treatment="preserve">
			<xs:value-of select="text" />
		</fo:block>

		<fo:block xs:use-attribute-sets="block-style" margin-bottom="40px"
			linefeed-treatment="preserve">
			<xs:value-of select="greeting" />
		</fo:block>

		<fo:block xs:use-attribute-sets="block-style" margin-bottom="20px"
			linefeed-treatment="preserve">
			<xs:value-of select="sender/surname" />
			<xs:text> </xs:text>
			<xs:value-of select="sender/name" />
		</fo:block>
		<xs:if test="facilities!=''">
			<fo:block xs:use-attribute-sets="block-style"
				linefeed-treatment="preserve">
				<xs:text>Anlage:</xs:text>
			</fo:block>
			<fo:block xs:use-attribute-sets="block-style"
				linefeed-treatment="preserve">
				<xs:value-of select="facilities" />
			</fo:block>
		</xs:if>
	</xs:template>

</xs:stylesheet>