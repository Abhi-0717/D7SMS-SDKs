Pod::Spec.new do |s|
  s.name             = "D7SMS"
  s.version          = "1.0.0"
  s.summary          = <<-SUMMARY
  <p>D7 SMS allows you to reach your customers via SMS over D7's own connectivity to global mobile networks. D7 provides reliable and cost-effective SMS services to businesses across all industries and aims to connect all countries and territories via direct connections.</p>

SUMMARY
  s.homepage         = "https://d7networks.com"
  s.license          = 'MIT'
  s.author           = { "D7SDK" => "support@d7networks.com" }

  s.requires_arc     = true
  s.ios.deployment_target = '6.0'
  s.osx.deployment_target = '10.8'
  s.source           = {:git => ''}

  s.source_files     = 'D7SMS/**/*.{h,m}'

  s.dependency       'Unirest-APIMATIC'
  s.dependency       'JSONModel'
  s.dependency       'ISO8601DateFormatter', '~> 0.7'
end
