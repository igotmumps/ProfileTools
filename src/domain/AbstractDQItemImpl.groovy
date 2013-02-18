package domain

class AbstractDQItemImpl extends AbstractDQItem {
	Boolean itemFound
	def fileName

	public AbstractDQItemImpl(String item) {

		this.fileName = item
		String type = item.tokenize('.').last()

		switch (type.toLowerCase()) {
			case 'aggregate':
				this.key = "AGID"
				this.column = "DES"
				this.table = "DBTBL22"
				break

			case 'batch':
				this.key = "BCHID"
				this.column = "DES"
				this.table = "DBTBL33"
				break

			case 'col':
				this.key = "DI"
				this.column = "DES"
				this.table = "DBTBL1D"
				this.condition = "FID"
				break

			case "g":
				this.itemFound = false
				break

			case "exp":
				this.key = "EXPID"
				this.column = "DESC"
				this.table = "DBTBL17"
				break

			case "executive":
				this.key = "EXCID"
				this.column = "DES"
				this.table = "DBTBL3"
				break

			case "foreign key":
				this.key = "FKEYS"
				this.table = "DBTBL1F"
				this.condition = "FID"
				this.column = "TBLREF"
				break

			case "index":
				this.key = "INDEXNM"
				this.column = "IDXDESC"
				this.table = "DBTBL8"
				this.condition = "FID"
				break

			case "journal":
				this.key = "JRNID"
				this.column = "DES"
				this.table = "DBTBL8"
				this.condition = "PRITABLE"
				break

			case "lookup doc":
				this.key = "FID"
				this.column = "FDESC"
				this.table = "DBTBL12"
				break

			case "m":
				this.key = "RTN"
				this.column = "DES"
				this.table = "ZDBTBL"
				break

			case "pre post lib":
				this.key = "PID"
				this.column = "DESC"
				this.table = "DBTBL13"
				break

			case "proc":
				this.key = "PROCID"
				this.column = "DES"
				this.table = "DBTBL25"
				break

			case "query":
				this.key = "QID"
				this.column = "DESC"
				this.table = "DBTBL4"
				break

			case "record map":
				this.key = "IDEXCH"
				this.column = "DES"
				this.table = "DBTBL16"
				break

			case "report":
				this.key = "RID"
				this.column = "DESC"
				this.table = "DBTBL5H"
				break

			case "screen":
				this.key = "SID"
				this.column = "DESC"
				this.table = "DBTBL2"
				break

			case "tbl":
				this.key = "FID"
				this.column = "DES"
				this.table = "DBTBL1"
				this.condition = "TABLE"
				break

			case "trigger":
				this.key = "TRGID"
				this.column = "DES"
				this.table = "DBTBL7"
				this.condition = "TABLE"
				break

			default:
				itemFound = false;
		}
	}
}
