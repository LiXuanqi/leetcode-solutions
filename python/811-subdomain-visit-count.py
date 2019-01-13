class Solution:
    def subdomainVisits(self, cpdomains):
        """
        :type cpdomains: List[str]
        :rtype: List[str]
        """
        map = {};
        for domain in cpdomains:
            times, url = domain.split(' ')
            subdomains = url.split('.')[::-1]
            key = ""
            for i, subdomain in enumerate(subdomains):
                if i != 0:
                    key = '.' + key
                key = subdomain + key
                map[key] = map.get(key, 0) + int(times)
        return [str(v) + " " + k for k, v in map.items()]
            