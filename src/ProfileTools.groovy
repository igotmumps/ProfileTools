import domain.*

class ProfileTools {
	static void main(String[] args) {
		def cli = new CliBuilder(usage: 'groovy ProfileTools [-tlpg] [arrguments]')
		cli.with {
			h longOpt: 'help',        'Show usage information'
			t longOpt:  'target',     'Target a specific Profile environment'
			l longOpt:  'login',       'Login to the Profile target env.'
			s longOpt: 'save',        'Save a Profile element to the target env.'
			g longOpt: 'get',          'Retrieve an element for the target env.'
		}

		def options = cli.parse(args)
		if (!options) {
			return
		}

		if (options.h) {
			cli.usage()
			return
		}

		if (options.t) {
			new ProfileTools().run 'target', options.arguments
		}

		if (options.l) {
			new ProfileTools().run 'login', options.arguments
		}

		if (options.s) {
			new ProfileTools().run 'save', options.arguments().get(0)
		}

		if (options.g) {
			new ProfileTools().run 'get', options.arguments
		}

	}


	def run(cmd, args) {
		println "Command:" + cmd
		println "args:" + args

		switch (cmd) {
			case 'save':
				this.save(args)
				break
			case 'target':
				this.target(args)
				break
		}
	}


	def save(args) {
		def dqItem = new AbstractDQItemImpl(args)
		def pfCon = new AbstractProfileConnectionPropertiesImpl()
		pfCon.env = 'prfdev01'
		pfCon.userID = 8888
		pfCon.pwd = 'dude'
		pfCon.port = 8080
		println pfCon.env
		println dqItem.key
	}

}

